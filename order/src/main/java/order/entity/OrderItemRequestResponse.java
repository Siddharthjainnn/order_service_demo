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
}

