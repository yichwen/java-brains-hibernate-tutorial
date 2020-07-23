package io.tao.namedquery;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@NamedQuery(name = "UserDetails.byId", query = "from UserDetails where userId = :userId")
@NamedNativeQuery(name = "UserDetails.byName", query = "select * from user_details where username = :username", resultClass = UserDetails.class)
@Table(name = "USER_DETAILS")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String userName;

}
