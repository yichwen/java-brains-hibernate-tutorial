package io.tao.collection;

import lombok.Data;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String userName;

    // this will create another table userdetails_addresses
    // with the foreign key as userdetails_userid
    // fetch type is LAZY by default, see HibernateCollectionTest#getUser() for LAZY initialization impact
    @ElementCollection(fetch = FetchType.EAGER)
    // optional, change the default table name and default foreign key
    @JoinTable(name = "USER_ADDRESS", joinColumns = @JoinColumn(name = "USER_ID"))
    // this is not a JPA API, is hibernate-specific to define primary key
    // new field called ADDRESS_ID, with hi-lo generator and long type
    // hilo generator was deprecated in hibernate 5
    // @GenericGenerator(name = "hilo-gen", strategy = "hilo")
    // need to understand more on this generator
    @GenericGenerator(name = "hilo-gen",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    // will have another sequence called hilo_sequence, and used sequence from this object
                    // @Parameter(name = "optimizer", value = "hilo")
                    @Parameter(name = "sequence_name", value = "hilo_sequence"),
                    @Parameter(name = "initial_value", value = "1"),
                    @Parameter(name = "increment_size", value = "3")})
    @CollectionId(columns = { @Column(name = "ADDRESS_ID") }, generator = "hilo-gen", type = @Type(type = "long"))
    // private Set<Address> addresses = new HashSet<Address>();
    // use generic Collection, use ArrayList because it supports indexes
    private Collection<Address> addresses = new ArrayList<Address>();


}
