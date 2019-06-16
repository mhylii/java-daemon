package com.cn.mical.springboot.controller;

import com.alibaba.fastjson.JSONObject;
import com.cn.mical.springboot.pojo.User;
import com.cn.mical.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    public JSONObject save(HttpServletRequest request, HttpServletResponse response) throws Exception{
        JSONObject jsonObject = new JSONObject();
        String name = request.getParameter("name");
        boolean result = false;
        User user = new User();
        if (!StringUtils.isEmpty(name)) {
            user.setUserName(name);
            result = UserRepositorypository.save(user);
        }

        jsonObject.put("flag", result);
        jsonObject.put("data", user);
        return jsonObject;
    }

    @GetMapping("/person/get/{id}")
    public JSONObject get(@PathVariable("id") Integer id) throws Exception{
        JSONObject jsonObject = new JSONObject();
        User user = null;
        if (!StringUtils.isEmpty(id)) {
            user = UserRepositorypository.get(id);
        }

        if (user == null) {
            user = new User();
        }

        jsonObject.put("data", user);
        return jsonObject;
    }
}
