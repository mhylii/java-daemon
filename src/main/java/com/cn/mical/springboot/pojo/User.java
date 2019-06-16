package com.cn.mical.springboot.pojo;

/**
 * @program: springboot-helloword
 * @Date: 2019/6/16 12:56
 * @Author: qinxinhua
 * @Description:
 */
public class User {
    private Integer id;
    private String userName;

    public User() {
    }

    public User(Integer id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", userName='" + userName + "'}";
    }
}
