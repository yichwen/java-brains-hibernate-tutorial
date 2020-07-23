package io.tao.inheritance.joined;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class FourWheeler extends Vehicle {
    private String SteeringWheel;
}
