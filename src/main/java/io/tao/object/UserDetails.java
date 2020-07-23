package io.tao.object;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
// deprecated, select before update, if after select object is not changed, will not trigger update
@org.hibernate.annotations.Entity(selectBeforeUpdate = true)
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String userName;

}
