package io.tao;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "USER_DETAILS")
public class UserDetailsWithSurrogateKey {

    @Id
    // asking hibernate to generate value
    // GenerationType.AUTO -> hibernate decision, default
    // GenerationType.IDENTITY -> identity column
    // GenerationType.SEQUENCE -> database sequence
    // GenerationType.TABLE -> database table
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String userName;

}
