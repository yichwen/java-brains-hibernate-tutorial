package io.tao;

import lombok.Data;

import javax.persistence.*;

// no in use, basic info
@Data
@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String userName;

}
