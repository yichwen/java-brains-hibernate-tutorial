package io.tao.onetoone;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Vehicle {

    @Id @GeneratedValue
    private int vehicleId;
    private String vehicleName;
}
