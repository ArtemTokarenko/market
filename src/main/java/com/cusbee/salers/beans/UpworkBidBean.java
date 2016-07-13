package com.cusbee.salers.beans;

import com.cusbee.salers.entity.UpworkBid;

import java.util.Date;

public class UpworkBidBean {

    private Long id;
    private Long salerId;
    private String comment;
    private Date date;
    private Date updatedDate;
    private String url;
    private String account;

    public static UpworkBidBean toBean(UpworkBid bid) {
        UpworkBidBean bean = new UpworkBidBean();
        bean.setId(bid.getId());
        bean.setSalerId(bid.getSaler().getId());
        bean.setComment(bid.getComment());
        bean.setDate(bid.getDate());
        //        bean.setUpdatedDate(bid.getUpdatedDate());
        bean.setUrl(bid.getUrl());
        bean.setAccount(bid.getAccount());
        return bean;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSalerId() {
        return salerId;
    }

    public void setSalerId(Long salerId) {
        this.salerId = salerId;
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

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
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
}
