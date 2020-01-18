package com.miaosha.controller;

import com.miaosha.controller.viewobject.ItemVO;
import com.miaosha.error.BusinessException;
import com.miaosha.response.CommonRetuenType;
import com.miaosha.service.ItemService;
import com.miaosha.service.model.ItemModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName ItemController
 * @Description TODO
 * @Author ouyang
 * @Data 2020-01-16 15:05
 * @Version 1.0
 **/

@Controller
@RequestMapping("/item")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class ItemController extends BaseController {

    @Autowired
    private ItemService itemService;

    // items pages view
    @RequestMapping(value = "/list", method = {RequestMethod.GET})
    @ResponseBody
    public CommonRetuenType listItem(){
        // get item model list via service method
        List<ItemModel> itemModelList = itemService.listItem();

        // convert model to view object
        List<ItemVO> itemVOList = itemModelList.stream().map(itemModel -> {
            ItemVO itemVO = this.convertVOFromModel(itemModel);
            return itemVO;
        }).collect(Collectors.toList());

        // return the view object list
        return CommonRetuenType.create(itemVOList);
    }

    // items details view
    @RequestMapping(value = "/get", method = {RequestMethod.GET})
    @ResponseBody
    public CommonRetuenType getItem(@RequestParam(name = "id") Integer id){

        ItemModel itemModel = itemService.getItemById(id);

        ItemVO itemVO = this.convertVOFromModel(itemModel);

        return CommonRetuenType.create(itemVO);
    }

    @RequestMapping(value = "/create", method = {RequestMethod.POST})
    @ResponseBody
    public CommonRetuenType createItem(@RequestParam(name = "title") String title,
                                       @RequestParam(name = "description") String description,
                                       @RequestParam(name = "price") BigDecimal price,
                                       @RequestParam(name = "stock") Integer stock,
                                       @RequestParam(name = "imgUrl") String imgUrl) throws BusinessException {

        // encapsulate service request to create item
        ItemModel itemModel = new ItemModel();
        itemModel.setTitle(title);
        itemModel.setPrice(price);
        itemModel.setStock(stock);
        itemModel.setDescription(description);
        itemModel.setImgUrl(imgUrl);

        ItemModel itemModelForReturn = itemService.createModel(itemModel);
        ItemVO itemVO = this.convertVOFromModel(itemModelForReturn);

        return CommonRetuenType.create(itemVO);

    }

    private ItemVO convertVOFromModel(ItemModel itemModel){
        if(itemModel == null){
            return null;
        }
        ItemVO itemVO = new ItemVO();
        BeanUtils.copyProperties(itemModel, itemVO);
        return itemVO;
    }

}
