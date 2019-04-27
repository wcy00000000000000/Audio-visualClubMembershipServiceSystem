package com.wcy.audio_visual_club_membership_service_system.pojo;

import java.io.Serializable;

public class OrderProduct extends OrderProductKey implements Serializable {
    private Integer number;

    private Double price;

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}