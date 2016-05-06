package com.orderserver.models;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by proton on 01.02.2016.
 */
@Entity
@Table(name = "orders")
@NamedQueries({
        @NamedQuery(name = "getOrderById", query = "SELECT a FROM Order a WHERE a.id = :id" ),
        @NamedQuery(name = "getOrderByLink", query = "SELECT a FROM Order a WHERE a.link = :link" ),
        @NamedQuery(name = "getOrdersByUserId", query = "SELECT a FROM Order a WHERE a.user = :user")
})
public class Order implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Integer id;

    @JoinColumn(name = "user_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    @Column
    private String link;

    @Column
    private String imageUrl;

    @Column
    private Integer pcs;

    @Column
    private String comment;

    @Column
    private String status;

    @Column
    private Boolean pay;

    @Column
    private String name;

    public User getUser() {
        return user;
    }

    public Order setUser(User user) {
        this.user = user;
        return this;
    }

    public String getLink() {
        return link;
    }

    public Order setLink(String link) {
        this.link = link;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public Order setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public Integer getPcs() {
        return pcs;
    }

    public Order setPcs(Integer pcs) {
        this.pcs = pcs;
        return this;
    }

    public String getComment() {
        return comment;
    }

    public Order setComment(String comment) {
        this.comment = comment;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Order setStatus(String status) {
        this.status = status;
        return this;
    }

    public Boolean getPay() {
        return pay;
    }

    public Order setPay(Boolean pay) {
        this.pay = pay;
        return this;
    }

    public String getName() {
        return name;
    }

    public Order setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public Order setId(Integer id) {
        this.id = id;
        return this;
    }
}
