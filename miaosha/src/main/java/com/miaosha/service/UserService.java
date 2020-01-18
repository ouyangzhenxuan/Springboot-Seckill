package com.miaosha.service;

import com.miaosha.error.BusinessException;
import com.miaosha.service.model.UserModel;

public interface UserService {

    // get user by id
    UserModel getUserById(Integer id);

    void register(UserModel userModel) throws BusinessException;

    /*
    * telphone: user phone number
    * encrptpassword: encrpt password*/
    UserModel validateLogin(String telphone, String encrptpassword) throws BusinessException;

}
