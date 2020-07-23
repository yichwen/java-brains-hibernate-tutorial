package io.tao.inheritance.joined;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Vehicle {

    @Id @GeneratedValue
    private int vehicleId;

    private String vehicleName;
}
