package io.tao.inheritance.singletable;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
// change the dValue when persist
@DiscriminatorValue("Bike")
public class TwoWheeler extends Vehicle {
    private String SteeringHandle;
}
