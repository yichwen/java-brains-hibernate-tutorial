package io.tao.inheritance.joined;

import lombok.Data;

import javax.persistence.Entity;

@Data
@Entity
public class TwoWheeler extends Vehicle {
    private String SteeringHandle;
}
