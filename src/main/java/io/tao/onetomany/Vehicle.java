package io.tao.onetomany;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Vehicle {

    @Id @GeneratedValue
    private int vehicleId;

    private String vehicleName;

    @ManyToOne
    // add @JoinColumn to change the name
//    @JoinColumn(name = "USER_ID")
    private UserDetails user;
}
