package io.tao.crud;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String userName;

}
