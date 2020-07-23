package io.tao.embed;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "EMBEDDED_USER_DETAILS")
public class UserDetails {

    @EmbeddedId
    private LogInName userId;

    private String userName;

    // @Embedded is not necessary if Address class has been annotated @Embeddable
    @Embedded
    // to override the address default @Column definition
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "HOME_STREET_NAME")),
            @AttributeOverride(name = "city", column = @Column(name = "HOME_CITY_NAME")),
            @AttributeOverride(name = "state", column = @Column(name = "HOME_STATE_NAME")),
            @AttributeOverride(name = "pincode", column = @Column(name = "HOME_PIN_CODE")),
    })
    private Address homeAddress;

    @Embedded
    private Address officeAddress;

}
