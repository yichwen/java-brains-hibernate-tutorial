package io.tao;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "USER_DETAILS")
public class UserDetailsWithLob {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String userName;

    private Date joinedDate;

    private String Address;

    @Lob    // clob (char) or blob (byte)
    private String description;

}
