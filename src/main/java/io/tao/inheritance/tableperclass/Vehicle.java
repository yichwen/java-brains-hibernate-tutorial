package io.tao.inheritance.tableperclass;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Vehicle {

    @Id @GeneratedValue
    private int vehicleId;

    private String vehicleName;
}
