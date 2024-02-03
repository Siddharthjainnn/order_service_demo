package order.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "party")
public class Party implements Serializable {
    @Id
    @Column(name = "party_id", length = 20, nullable = false)
    private String partyId;

    @Column(name = "party_enum_type_id", length = 20)
    private String partyEnumTypeId;

    // Getters, setters, and other methods
}
