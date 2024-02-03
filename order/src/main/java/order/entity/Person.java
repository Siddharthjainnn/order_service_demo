package order.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "person")
public class Person implements Serializable {
    @Id
    @Column(name = "party_id", length = 20, nullable = false)
    private String partyId;

    @Column(name = "first_name", length = 255)
    private String firstName;

    @Column(name = "middle_name", length = 255)
    private String middleName;

    @Column(name = "last_name", length = 255)
    private String lastName;

    @Column(name = "gender", length = 1)
    private String gender;

    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Column(name = "marital_status_enum_id", length = 20)
    private String maritalStatusEnumId;

    @Column(name = "employment_status_enum_id", length = 20)
    private String employmentStatusEnumId;

    @Column(name = "occupation", length = 255)
    private String occupation;

}
