package com.miaosha.service.model;

import java.math.BigDecimal;

/**
 * @ClassName OrderModel
 * @Description TODO
 * @Author ouyang
 * @Data 2020-01-17 14:02
 * @Version 1.0
 **/

// model for transaction
public class OrderModel {

    //20181021000021123
    private String id;

    private Integer userId;

    private Integer itemId;

    // if it is not null, then the transaction is based on promo price
    private Integer promoId;

    // unit price, if promoId is not null, then it means promo price
    private BigDecimal itemPrice;

    // order amount
    private Integer amount;

    // order total price, if promoId is not null, then it means promo price
    private BigDecimal orderPrice;

    public Integer getPromoId() {
        return promoId;
    }

    public void setPromoId(Integer promoId) {
        this.promoId = promoId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }
}
