package order.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "order_header")
public class OrderHeader implements Serializable {
    @Id
    @Column(name = "order_id", length = 20, nullable = false)
    private String orderId;

    @Column(name = "order_name", length = 255)
    private String orderName;

    @Column(name = "placed_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date placedDate;

    @Column(name = "approved_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date approvedDate;

    @Column(name = "status_id", length = 20)
    private String statusId;

    @Column(name = "party_id", length = 20)
    private String partyId;

    @Column(name = "currency_uom_id", length = 20)
    private String currencyUomId;

    @Column(name = "product_store_id", length = 20)
    private String productStoreId;

    @Column(name = "sales_channel_enum_id", length = 20)
    private String salesChannelEnumId;

    @Column(name = "grand_total", precision = 24, scale = 4)
    private Double grandTotal;

    @Column(name = "completed_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date completedDate;

}


