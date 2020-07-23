package io.tao.onetoone;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String userName;

    @OneToOne
    // @Column is not allowed on @OneToOne property, so use @JoinColumn
    @JoinColumn(name = "VEHICLE_ID")
    private Vehicle vehicle;


}
