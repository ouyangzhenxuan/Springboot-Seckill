package com.miaosha.service;


import com.miaosha.service.model.PromoModel;

public interface PromoService {

    // get promo info based on item id
    PromoModel getPromoByItemId(Integer itemId);

    //

}
