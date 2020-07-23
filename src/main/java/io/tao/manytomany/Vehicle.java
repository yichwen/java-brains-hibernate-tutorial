package io.tao.manytomany;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
public class Vehicle {

    @Id @GeneratedValue
    private int vehicleId;

    private String vehicleName;

    @ManyToMany(mappedBy = "vehicles")
    private Collection<UserDetails> users = new ArrayList<>();
}
