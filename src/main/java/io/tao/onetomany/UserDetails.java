package io.tao.onetomany;

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


    // another way without create relationship table
    @OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
    // this will create one to many relationship table
//     @OneToMany
//    @JoinTable(name = "USER_VEHICLE",
//        joinColumns = @JoinColumn(name = "USER_ID"),
//        inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID")
//    )
    private Collection<Vehicle> vehicles = new ArrayList<>();

}
