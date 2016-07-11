package com.cusbee.salers.beans;

import com.cusbee.salers.entity.Saler;
import com.cusbee.salers.entity.UpworkBid;
import com.cusbee.salers.enums.Role;

import java.util.List;

public class SalerBean {

    private Integer id;
    private String firstname;
    private String lastname;
    private String login;
    private String password;
    private String email;
    private String phonenumber;
    private Role role;
    private List<UpworkBid> upworkBidList;

    public static SalerBean toBean(Saler saler) {
        SalerBean bean = new SalerBean();
        bean.setId(saler.getId());
        bean.setFirstname(saler.getFirstname());
        bean.setLastname(saler.getLastname());
        bean.setLogin(saler.getLogin());
        bean.setPassword(saler.getPassword());
        bean.setEmail(saler.getEmail());
        bean.setPhonenumber(saler.getPhonenumber());
        bean.setRole(saler.getRole());
        bean.setUpworkBidList(saler.getUpworkBidList());
        return bean;
    }

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
