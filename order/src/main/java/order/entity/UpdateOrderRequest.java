package order.entity;

import lombok.Data;

@Data
public class UpdateOrderRequest {

    private String orderId;
    private String orderName;
}
