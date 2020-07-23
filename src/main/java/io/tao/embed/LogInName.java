package io.tao.embed;

import lombok.Data;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;

@Embeddable
@Data
public class LogInName implements Serializable {

    // @GeneratedValue is not able to use in @Embeddable
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String email;
}
