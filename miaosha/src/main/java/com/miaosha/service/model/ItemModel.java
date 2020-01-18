package com.miaosha.service.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @ClassName ItemModel
 * @Description TODO
 * @Author ouyang
 * @Data 2020-01-16 13:31
 * @Version 1.0
 **/

public class ItemModel {

    private Integer id;

    // item name
    @NotBlank(message = "Item name can't be null")
    private String title;

    @NotNull(message = "Item price can't be null")
    @Min(value = 0, message = "Item Price must be greater than 0")
    private BigDecimal price;

    // items remaining amount
    @NotNull(message = "Item stocks can't be null")
    private Integer stock;

    @NotBlank(message = "Item description can't be blank")
    private String description;

    // items sales amount
    private Integer sales;

    // items image url address
    @NotBlank(message = "Item image can't be blank")
    private String imgUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
