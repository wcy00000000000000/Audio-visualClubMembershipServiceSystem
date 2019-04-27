package com.wcy.audio_visual_club_membership_service_system.pojo;

import java.util.Date;

public class Order {
    private Integer id;

    private Integer memberId;

    private Date orderDate;

    private Date diliveryDate;

    private String place;

    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getDiliveryDate() {
        return diliveryDate;
    }

    public void setDiliveryDate(Date diliveryDate) {
        this.diliveryDate = diliveryDate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}