package com.miaosha.controller;

import com.alibaba.druid.util.StringUtils;
import com.miaosha.controller.viewobject.UserVO;
import com.miaosha.error.BusinessException;
import com.miaosha.error.CommonError;
import com.miaosha.error.EmBusinessError;
import com.miaosha.response.CommonRetuenType;
import com.miaosha.service.UserService;
import com.miaosha.service.model.UserModel;
import org.apache.catalina.User;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import sun.security.provider.MD5;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author ouyang
 * @Data 2020-01-09 17:21
 * @Version 1.0
 **/

@Controller("user")
@RequestMapping("/user")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @Autowired
    private  HttpServletRequest httpServletRequest;


    @RequestMapping(value = "/login", method = {RequestMethod.POST})
    @ResponseBody
    public CommonRetuenType login(@RequestParam(name = "telphone") String telphone,
                                  @RequestParam(name = "password") String password) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        // input parameter validation
        if(org.apache.commons.lang3.StringUtils.isEmpty(telphone) || org.apache.commons.lang3.StringUtils.isEmpty(password)){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "Telphone and password can't be null");
        }

        // login service, check if the user login is validated
        UserModel userModel = userService.validateLogin(telphone, this.EncodeByMD5(password));

        // add login success proof to the session
        this.httpServletRequest.getSession().setAttribute("IS_LOGIN", true);
        this.httpServletRequest.getSession().setAttribute("LOGIN_USER", userModel);

        return CommonRetuenType.create(null);
    }

    // user register api
    @RequestMapping(value = "/register", method = {RequestMethod.POST})
    @ResponseBody
    public CommonRetuenType register(@RequestParam(name = "telphone") String telphone,
                                     @RequestParam(name = "otpCode") String otpCode,
                                     @RequestParam(name = "name") String name,
                                     @RequestParam(name = "gender") Integer gender,
                                     @RequestParam(name = "age") Integer age,
                                     @RequestParam(name = "password") String password) throws BusinessException, UnsupportedEncodingException, NoSuchAlgorithmException {
        // validate telphone with otp matching
        String inSessionOtpCode = (String) this.httpServletRequest.getSession().getAttribute(telphone);
        if(!StringUtils.equals(otpCode, inSessionOtpCode)){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "otp code not validated");
        }

        // register process
        UserModel userModel = new UserModel();
        userModel.setName(name);
        userModel.setGender(gender);
        userModel.setAge(age);
        userModel.setTelephone(telphone);
        userModel.setRegisterMode("byphone");
        userModel.setThirdPartyId("phone");
        userModel.setEncrptPassword(this.EncodeByMD5(password));
        userService.register(userModel);
        return CommonRetuenType.create(null);

    }

    public String EncodeByMD5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64En = new BASE64Encoder();
        String newstr = base64En.encode(md5.digest(str.getBytes("utf-8")));
        return newstr;
    }

    // user otp text msg receivers api
    @RequestMapping(value = "/getotp", method = {RequestMethod.POST})
    @ResponseBody
    public CommonRetuenType getOtp(@RequestParam(name = "telphone") String telphone){
        // generate OTP validation code
        Random random = new Random();
        int randomint = random.nextInt(99999);
        randomint += 10000;
        String otpCode = String.valueOf(randomint);


        // link OPT code with user's telphone number, using httpsession method to bond
        httpServletRequest.getSession().setAttribute(telphone, otpCode);


        // send OPT validation code to user, (ignored for now)
        System.out.println("telphone = " + telphone + " & otp code = " + otpCode);

        return CommonRetuenType.create(null);
    }

    @RequestMapping("/get")
    @ResponseBody
    public CommonRetuenType getUser(@RequestParam(name = "id") Integer id) throws BusinessException {
        // 调用 service 服务获取对应id的用户对象并返回给前端
        UserModel userModel = userService.getUserById(id);

        // 若获取的用户信息不存在
        if(userModel == null){
//            userModel.setEncrptPassword("123");
            throw new BusinessException(EmBusinessError.USER_NOT_EXIST);
        }

        // 将核心领域模型用户对象转换卫可供UI使用的viewobject
        UserVO userVO = converFromModel(userModel);

        return CommonRetuenType.create(userVO);
    }

    private UserVO converFromModel(UserModel userModel){
        if(userModel == null) return null;

        UserVO userVO = new UserVO();
        BeanUtils.copyProperties(userModel, userVO);
        return userVO;
    }

}
