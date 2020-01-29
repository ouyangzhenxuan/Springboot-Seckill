package com.miaosha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ClassName ViewController
 * @Description TODO
 * @Author ouyang
 * @Data 2020-01-29 15:09
 * @Version 1.0
 **/

@Controller
//@RequestMapping("/index")
public class ViewController {

    @RequestMapping("/logpage")
    public String goLogin(){
        System.out.println("login");
        return "login";
    }
}
