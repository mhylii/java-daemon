package com.cn.mical.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.cn.mical.springboot.pojo.User;
import com.cn.mical.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springboot-helloword
 * @Date: 2019/6/16 13:09
 * @Author: qinxinhua
 * @Description:
 */
@RestController
public class UserController {
    private final UserRepository UserRepositorypository;

    @Autowired
    public UserController(UserRepository userRepositorypository) {
        UserRepositorypository = userRepositorypository;
    }

    @PostMapping("/person/save")
    public JSONObject save(@RequestParam(value = "name") String name) throws Exception{
        JSONObject jsonObject = new JSONObject();
        boolean result = false;
        User user = new User();
        if (!StringUtils.isEmpty(name)) {
            user.setUserName(name);
            System.out.println(user);
            result = UserRepositorypository.save(user);
        }

        jsonObject.put("flag", result);
        jsonObject.put("data", user);
        return jsonObject;
    }

    @GetMapping("/person/get/{id}")
    public User get(@PathVariable("id") Integer id) throws Exception{
        User user = new User();
        if (!StringUtils.isEmpty(id)) {
            user = UserRepositorypository.get(id);
        }
        return user;
    }

    @GetMapping("/person/getUserInfo")
    public User getUserInfo(@RequestParam("id") Integer id) throws Exception{
        User user = user = UserRepositorypository.get(id);
        return user;
    }
}
