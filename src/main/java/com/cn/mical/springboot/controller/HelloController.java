package com.cn.mical.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: helloword
 * @Date: 2019/6/15 21:52
 * @Author: qinxinhua
 * @Description:
 */
@RestController
public class HelloController {

    @RequestMapping("/say")
    public String say(){
        return "Hello Word";
    }
}
