package com.cn.mical.springboot.repository;

import com.cn.mical.springboot.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @program: springboot-helloword
 * @Date: 2019/6/16 12:58
 * @Author: qinxinhua
 * @Description:
 */
@Repository
public class UserRepository {
    /**
    * @Description: 内存存储方式
    */
    private final ConcurrentHashMap repository = new ConcurrentHashMap();

    /**
    * @Description: id生成器
    */
    private final AtomicInteger idGenerator = new AtomicInteger();


    /**;
    * @Description:
    * @param [user]
    * @Return: boolean
    * @Date: 2019/6/16 13:00
    */
    public boolean save(User user){
        Integer id = idGenerator.incrementAndGet();
        user.setId(id);
        return repository.put(id, user) == null;
    }

    public User get(Integer id){
        User user = (User)repository.get(id);
        return user;
    }
    public Collection<User> findAll(){
        return repository.values();
    }

}
