package io.tao;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
// what is this different from @Table(name = "USER_DETAILS"), reflect in HQL
// if @Table is applied which means table name is "USER_DETAILS" but entity name is still "UserDetails"
// but now the following annotation will cause entity name and table name to be "USER_DETAILS" as well
@Entity(name = "USER_DETAILS")
public class UserDetailsWithEntityName {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String userName;

}
