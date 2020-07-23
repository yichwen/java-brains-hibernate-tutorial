package io.tao.embed;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

// in order to mark this as a value type
// in order to have not to create a separate table for this
// need to use @Embeddable to tell hibernate this object will be embedded inside something else
@Embeddable
@Data
public class Address {

    @Column(name = "STREET_NAME")
    private String street;

    @Column(name = "CITY_NAME")
    private String city;

    @Column(name = "STATE_NAME")
    private String state;

    @Column(name = "PIN_CODE")
    private String pincode;

}
