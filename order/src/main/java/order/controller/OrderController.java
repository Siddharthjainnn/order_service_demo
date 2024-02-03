package order.controller;

import order.entity.OrderHeader;
import order.entity.OrderItemRequestResponse;
import order.entity.UpdateOrderRequest;
import order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

   @Autowired
   OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody OrderHeader orderRequest) {
        String orderId = orderService.createOrder(orderRequest);
        return ResponseEntity.ok(orderId);
    }

    @PostMapping("/order-items/add")
    public ResponseEntity<Void> addOrderItems(@RequestBody OrderItemRequestResponse orderItemRequest) {
        orderService.addOrderItems(orderItemRequest);
        return ResponseEntity.ok().build();
    }


    @GetMapping("/allOrder")
    public ResponseEntity<List<OrderItemRequestResponse>> getAllOrders() {
        List<OrderItemRequestResponse> orders = orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderItemRequestResponse> getOrderById(@PathVariable String orderId) {
        OrderItemRequestResponse orderResponse = orderService.getOrderById(orderId);
        return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }


    @PatchMapping("/{orderId}")
    public ResponseEntity<OrderItemRequestResponse> updateOrderName(
            @RequestBody UpdateOrderRequest updateOrderRequest) {
        OrderItemRequestResponse orderResponse = orderService.updateOrderName(updateOrderRequest.getOrder_id(), updateOrderRequest.getOrder_name());
        return new ResponseEntity<>(orderResponse, HttpStatus.OK);
    }
}
