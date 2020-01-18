package com.miaosha.service.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * @ClassName UserModel
 * @Description TODO
 * @Author ouyang
 * @Data 2020-01-09 17:28
 * @Version 1.0
 **/

public class UserModel {

    private Integer id;

    @NotBlank(message = "User name can't be null")
    private String name;

    @NotNull(message = "You need to input gender")
    private Integer gender;

    @Min(value = 0, message = "Age needs to greater than 0")
    @Max(value = 150, message = "Age needs to be smaller than 150")
    private Integer age;

    @NotBlank(message = "Telephone can't be null")
    private String telephone;

    private String registerMode;
    private String thirdPartyId;

    @NotBlank(message = "Password can't be null")
    private String encrptPassword;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRegisterMode() {
        return registerMode;
    }

    public void setRegisterMode(String registerMode) {
        this.registerMode = registerMode;
    }

    public String getThirdPartyId() {
        return thirdPartyId;
    }

    public void setThirdPartyId(String thirdPartyId) {
        this.thirdPartyId = thirdPartyId;
    }

    public String getEncrptPassword() {
        return encrptPassword;
    }

    public void setEncrptPassword(String encrptPassword) {
        this.encrptPassword = encrptPassword;
    }
}
