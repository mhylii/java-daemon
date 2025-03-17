package com.cn.mical.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: helloword
 * @Date: 2022年6月22日22:34:02
 * @Author: linxin
 * @Description:
 */
@RestController
public class HelloController {

    @RequestMapping("/say")
    public String say(){
        return "加油努力学历啊，给自己制造鸡汤喝着学！我要进私企，我要进私企！";
    }
}
