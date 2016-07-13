package com.cusbee.salers.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "UPWORKBID")
public class UpworkBid {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SALER_ID")
    private Saler saler;

    @Column(name = "COMMENT")
    private String comment;

    @Column(name = "DATE")
    private Date date;

    @Column(name = "UPDATED_DATE")
    private Date updatedDate;

    @Column(name = "URL")
    private String url;

    @Column(name = "ACCOUNT")
    private String account;

    @Column(name = "ACTIVE")
    private Boolean active = true;

    public Saler getSaler() {
        return saler;
    }

    public void setSaler(Saler saler) {
        this.saler = saler;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Boolean isActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}