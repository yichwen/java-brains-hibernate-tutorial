package io.tao;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "USER_DETAILS")
public class UserDetailsWithTransientField {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String userName;

    private Date joinedDate;

    private String Address;

    // transient is used to ignore the field when object persist to database
    @Transient
    private String description;

}
