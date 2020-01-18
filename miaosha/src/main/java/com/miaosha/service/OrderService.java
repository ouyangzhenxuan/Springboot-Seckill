package com.miaosha.service;


import com.miaosha.error.BusinessException;
import com.miaosha.service.model.OrderModel;

public interface OrderService {

    // recommend: 1. use the promo id from URL, and validate the id to check if it is under promotion within the create order API
    // 2. In the create order API, check if the item has promotion, if if is, create order under promotion price
    OrderModel createOrder(Integer userId, Integer itemId, Integer promoId, Integer amount) throws BusinessException;




}
