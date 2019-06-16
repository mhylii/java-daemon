package com.cn.mical.springboot.config;

import com.cn.mical.springboot.pojo.User;
import com.cn.mical.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

/**
 * @program: springboot-helloword
 * @Date: 2019/6/16 14:52
 * @Author: qinxinhua
 * @Description: 路由器函数配置
 */
@Configuration
public class RouterFunctionConfiguration {

    /**
     * Servlet
     *    请求接口：ServletRequest 或者 HttpServletRequest
     *    请求接口：ServletResponse 或者 HttpServletResponse
     *    Spring 5.0 后重新定义接口
     *    请求接口：ServerRequest
     *    请求接口：ServerResponse
     *
     *    既可支持 Servlet 规范，也可以支持自定义，比如Netty（Web Server）
     */

    @Bean
    @Autowired
    public RouterFunction<ServerResponse> personFindAll(UserRepository userRepository) {
        RouterFunctions.route();
        RouterFunction<ServerResponse> route = RouterFunctions.route(
            RequestPredicates.GET("/person/findAll"),
            request ->{
                //返回所有数据
                Collection<User> users = userRepository.findAll();

                Mono<ServerResponse> responseMono= null;
                Flux<User> userFlux = Flux.fromIterable(users);
                return ServerResponse.ok().body(userFlux, User.class);
            }
        );
        return route;
    }
}
