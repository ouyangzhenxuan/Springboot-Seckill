package com.miaosha;

import com.miaosha.dao.UserDOMapper;
import com.miaosha.dataobject.UserDO;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@MapperScan("com.miaosha.dao")
public class MiaoshaApplication {

    @Autowired
    private UserDOMapper userDOMapper;

	public static void main(String[] args) {
		SpringApplication.run(MiaoshaApplication.class, args);
	}

    @RequestMapping("/")
    public String home(){
        UserDO userDO = userDOMapper.selectByPrimaryKey(1);
        if(userDO == null){
            return "User not found";
        }else{
            return userDO.getName();
        }
    }

}
