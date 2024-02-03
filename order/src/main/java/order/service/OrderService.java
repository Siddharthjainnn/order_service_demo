package order.service;

import order.OrderNotFoundException;
import order.entity.OrderHeader;
import order.entity.OrderItem;
import order.entity.OrderItemRequestResponse;
import order.repository.OrderItemRepository;
import order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderItemRepository orderItemRepository;

    public String createOrder(OrderHeader orderRequest) {
        OrderHeader order = new OrderHeader();
        order.setOrderName(orderRequest.getOrderName());
        order.setPlacedDate(orderRequest.getPlacedDate());
        order.setApprovedDate(orderRequest.getApprovedDate());
        order.setStatusId(orderRequest.getStatusId());
        order.setPartyId(orderRequest.getPartyId());
        order.setCurrencyUomId(orderRequest.getCurrencyUomId());
        order.setProductStoreId(orderRequest.getProductStoreId());
        order.setSalesChannelEnumId(orderRequest.getSalesChannelEnumId());
        order.setGrandTotal(orderRequest.getGrandTotal());
        order.setCompletedDate(orderRequest.getCompletedDate());

        OrderHeader savedOrder = orderRepository.save(order);
        return savedOrder.getOrderId();
    }

    public void addOrderItems(OrderItemRequestResponse orderItemRequest) {

        for (OrderItem orderItem : orderItemRequest.getOrderItems()) {
            OrderItem savedOrderItem = orderItemRepository.save(orderItem);
        }
    }

    public List<OrderItemRequestResponse> getAllOrders() {
        List<OrderHeader> orders = orderRepository.findAll();
        return orders.stream().map(this::mapToOrderResponse).collect(Collectors.toList());
    }
    public OrderItemRequestResponse mapToOrderResponse(OrderHeader orderHeader) {
        OrderItemRequestResponse orderResponse = new OrderItemRequestResponse();
        orderResponse.setOrder_id(orderHeader.getOrderId());
        orderResponse.setOrder_name(orderHeader.getOrderName());
        orderResponse.setPlaced_date(orderHeader.getPlacedDate().toString());
        orderResponse.setApproved_date(orderHeader.getApprovedDate().toString());
        orderResponse.setStatus_id(orderHeader.getStatusId());
        orderResponse.setParty_id(orderHeader.getPartyId());
        orderResponse.setCurrency_uom_id(orderHeader.getCurrencyUomId());
        orderResponse.setProduct_store_id(orderHeader.getProductStoreId());
        orderResponse.setSales_channel_enum_id(orderHeader.getSalesChannelEnumId());
        orderResponse.setGrand_total(orderHeader.getGrandTotal() != null ?
                BigDecimal.valueOf(orderHeader.getGrandTotal()) : null);
        orderResponse.setCompleted_date(orderHeader.getCompletedDate().toString());
       return orderResponse;
    }

    public OrderItemRequestResponse getOrderById(String orderId) {
        Optional<OrderHeader> optionalOrder = orderRepository.findById(orderId);

        if (optionalOrder.isPresent()) {
            OrderHeader order = optionalOrder.get();
            return mapToOrderResponse(order);
        } else {
            throw new OrderNotFoundException("Order with ID " + orderId + " not found");
        }
    }

    public OrderItemRequestResponse updateOrderName(String orderId, String newOrderName) {
        Optional<OrderHeader> optionalOrder = orderRepository.findById(orderId);

        if (optionalOrder.isPresent()) {
            OrderHeader order = optionalOrder.get();
            order.setOrderName(newOrderName);
            orderRepository.save(order);
            return mapToOrderResponse(order);
        } else {
            throw new OrderNotFoundException("Order with ID " + orderId + " not found");
        }
    }


}
