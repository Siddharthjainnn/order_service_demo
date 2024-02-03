package order.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.io.Serializable;

@Entity
public class Product implements Serializable {
    @Id
    @Column(name = "product_id", length = 20, nullable = false)
    private String productId;

    @Column(name = "party_id", length = 20)
    private String partyId;

    @Column(name = "product_name", length = 255)
    private String productName;

    @Column(name = "description", length = 1000)
    private String description;

    @Column(name = "charge_shipping", length = 1)
    private String chargeShipping;

    @Column(name = "returnable", length = 1)
    private String returnable;
    // Getters, setters, and other methods
}