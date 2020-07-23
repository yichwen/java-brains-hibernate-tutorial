package io.tao.inheritance.singletable;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
// default strategy
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// set dtype column name and column type
@DiscriminatorColumn(
        name = "VEHICLE_TYPE",
        discriminatorType = DiscriminatorType.STRING
)
public class Vehicle {

    @Id @GeneratedValue
    private int vehicleId;

    private String vehicleName;
}
