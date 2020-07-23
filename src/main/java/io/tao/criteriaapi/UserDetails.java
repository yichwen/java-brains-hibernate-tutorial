package io.tao.criteriaapi;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@NamedQuery(name = "UserDetails.byId", query = "from UserDetails where userId = :userId")
@Table(name = "USER_DETAILS")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String userName;

}
