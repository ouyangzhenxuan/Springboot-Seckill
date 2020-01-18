package com.miaosha.service;

import com.miaosha.error.BusinessException;
import com.miaosha.service.model.ItemModel;

import java.util.List;

/**
 * @ClassName ItemService
 * @Description TODO
 * @Author ouyang
 * @Data 2020-01-16 13:48
 * @Version 1.0
 **/

public interface ItemService {

    // create item model
    ItemModel createModel(ItemModel itemModel) throws BusinessException;

    // get items list
    List<ItemModel> listItem();

    // get item by id
    ItemModel getItemById(Integer id);

    // reduce stock
    boolean decreaseStock(Integer itemId, Integer amount) throws BusinessException;

    // sales increase
    void increaseSales(Integer itemId, Integer amount) throws BusinessException;
}
