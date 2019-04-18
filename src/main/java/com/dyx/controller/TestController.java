package com.dyx.controller;

import com.dyx.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping(value = "/test1",method = RequestMethod.GET)
    public User test1(){
        return new User();
    }


}
