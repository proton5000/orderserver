package com.orderserver.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by proton on 27.01.2016.
 */
@Entity
@Table(name = "users")
@NamedQueries({
        @NamedQuery(name = "getUserByName", query = "SELECT a FROM User a WHERE a.name = :name" ),
        @NamedQuery(name = "getUserById", query = "SELECT a FROM User a WHERE a.id = :id" ),
        @NamedQuery(name = "getUserByEmail", query = "SELECT a FROM User a WHERE a.email = :email" ),
        @NamedQuery(name = "delUser", query = "DELETE FROM User a WHERE a.email = :email" ),
        @NamedQuery(name = "getUser", query = "SELECT a FROM User a WHERE a.name = :name AND a.password = :password" )
})
public class User implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Integer id;

//    @OneToMany(mappedBy = "user")
//    private List<Order> orders;

    @Column(unique = true)
    private String name;

    @Column
    private String password;

    @Column(unique = true)
    private String email;

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

}
