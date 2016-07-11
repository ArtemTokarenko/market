package com.cusbee.salers.entity;

import com.cusbee.salers.enums.Role;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SALER")

public class Saler {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "LASTNAME")
    private String lastname;

    @Column(name = "LOGIN")//unique=true
    private String login;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONE")
    private String phonenumber;

    @Column(name = "ROLE", nullable = false)
    @Enumerated(value = EnumType.ORDINAL)
    private Role role;

    @OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL }, mappedBy = "saler")
    private List<UpworkBid> upworkBidList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<UpworkBid> getUpworkBidList() {
        return upworkBidList;
    }

    public void setUpworkBidList(List<UpworkBid> upworkBidList) {
        this.upworkBidList = upworkBidList;
    }
}