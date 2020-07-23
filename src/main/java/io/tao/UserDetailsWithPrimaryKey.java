package io.tao;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "USER_DETAILS")
public class UserDetailsWithPrimaryKey {

    // id is primary key
    @Id
    private int userId;

    private String userName;

}
