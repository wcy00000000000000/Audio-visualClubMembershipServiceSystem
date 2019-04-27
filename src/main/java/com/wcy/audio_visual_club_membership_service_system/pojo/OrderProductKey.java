package com.wcy.audio_visual_club_membership_service_system.pojo;

import java.io.Serializable;

public class OrderProductKey implements Serializable {
    private Integer orderId;

    private Integer productId;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}