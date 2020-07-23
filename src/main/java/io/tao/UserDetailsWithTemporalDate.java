package io.tao;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "USER_DETAILS")
public class UserDetailsWithTemporalDate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String userName;

    // default is a timestamp, use @Temporal to change the format
    @Temporal(TemporalType.DATE)
    private Date joinedDate;

    private String Address;

    private String description;

}
