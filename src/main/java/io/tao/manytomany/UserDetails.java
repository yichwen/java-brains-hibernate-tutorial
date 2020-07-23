package io.tao.manytomany;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String userName;

    // this class as main to create the join table, whereas vehicle class will refer to this configuration
    // in vehicle class, it need to use mappedBy
    @ManyToMany
    @JoinTable(name = "USER_VEHICLE",
        joinColumns = @JoinColumn(name = "USER_ID"),
        inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID")
    )
    private Collection<Vehicle> vehicles = new ArrayList<>();

}
