package order.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;


@Data
public class OrderItemRequestResponse {
    private String order_id;
    private String order_name;
    private String placed_date;
    private String approved_date;
    private String status_id;
    private String party_id;
    private String currency_uom_id;
    private String product_store_id;
    private String sales_channel_enum_id;
    private BigDecimal grand_total;
    private String completed_date;
    private List<OrderItem> orderItems;

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getOrder_name() {
        return order_name;
    }

    public void setOrder_name(String order_name) {
        this.order_name = order_name;
    }

    public String getPlaced_date() {
        return placed_date;
    }

    public void setPlaced_date(String placed_date) {
        this.placed_date = placed_date;
    }

    public String getApproved_date() {
        return approved_date;
    }

    public void setApproved_date(String approved_date) {
        this.approved_date = approved_date;
    }

    public String getStatus_id() {
        return status_id;
    }

    public void setStatus_id(String status_id) {
        this.status_id = status_id;
    }

    public String getParty_id() {
        return party_id;
    }

    public void setParty_id(String party_id) {
        this.party_id = party_id;
    }

    public String getCurrency_uom_id() {
        return currency_uom_id;
    }

    public void setCurrency_uom_id(String currency_uom_id) {
        this.currency_uom_id = currency_uom_id;
    }

    public String getProduct_store_id() {
        return product_store_id;
    }

    public void setProduct_store_id(String product_store_id) {
        this.product_store_id = product_store_id;
    }

    public String getSales_channel_enum_id() {
        return sales_channel_enum_id;
    }

    public void setSales_channel_enum_id(String sales_channel_enum_id) {
        this.sales_channel_enum_id = sales_channel_enum_id;
    }

    public BigDecimal getGrand_total() {
        return grand_total;
    }

    public void setGrand_total(BigDecimal grand_total) {
        this.grand_total = grand_total;
    }

    public String getCompleted_date() {
        return completed_date;
    }

    public void setCompleted_date(String completed_date) {
        this.completed_date = completed_date;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }
}

