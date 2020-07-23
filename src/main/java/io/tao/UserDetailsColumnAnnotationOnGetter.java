package io.tao;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "USER_DETAILS")
public class UserDetailsColumnAnnotationOnGetter {

    private int userId;
    private String userName;

    // you can annotate @Column on getter, but only either all fields or all getters
    @Id
    @Column(name = "USER_ID")
    public int getUserId() {
        return userId;
    }

    // database will store the username as userName + " from getter"
    @Column(name = "USER_NAME")
    public String getUserName() {
        return userName + " from getter";
    }

}
