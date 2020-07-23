package io.tao.inheritance.tableperclass;

import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Entity
public class FourWheeler extends Vehicle {
    private String SteeringWheel;
}
