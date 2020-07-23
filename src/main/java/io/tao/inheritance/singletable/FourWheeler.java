package io.tao.inheritance.singletable;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
// change the dValue when persist
@DiscriminatorValue("Car")
public class FourWheeler extends Vehicle {
    private String SteeringWheel;
}
