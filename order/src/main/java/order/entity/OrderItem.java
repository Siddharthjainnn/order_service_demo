package order.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "order_item")
public class OrderItem implements Serializable {
    @EmbeddedId
    private OrderItemId id;

    @ManyToOne
    @JoinColumn(name = "order_id", insertable = false, updatable = false)
    private OrderHeader order;

    @Column(name = "product_id", length = 20)
    private String productId;

    @Column(name = "order_item_seq_id", length = 20)
    private String order_item_seq_id;

    @Column(name = "item_description", length = 255)
    private String itemDescription;

    @Column(name = "quantity", precision = 24, scale = 4)
    private Double quantity;

    @Column(name = "unit_amount", precision = 24, scale = 4)
    private Double unitAmount;

    @Column(name = "item_type_enum_id", length = 20)
    private String itemTypeEnumId;
}
