package com.example.springbootwebflux.demo1.route;

import com.example.springbootwebflux.demo1.handler.HelloWorldHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * Title:com.example.springbootwebflux.demo1.route
 * Description: 路由类
 * Copyright: Copyright (c) 2018
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/08/06  17:51
 */
@Configuration
public class HelloRouter {

    /**
     * RouterFunctions 对请求路由处理类，即将请求路由到处理器。这里将一个 GET 请求 /hello 路由到处理器
     * helloHandler 的 helloHandler 方法上。跟 Spring MVC 模式下的 HandleMapping 的作用类似。
     *  RouterFunctions.route(RequestPredicate, HandlerFunction) 方法，对应的入参是请求参数和处理函数，
     *  如果请求匹配，就调用对应的处理器函数
     * @param helloWorldHandler
     * @return
     */
    @Bean
    public RouterFunction<ServerResponse> helloRoute(HelloWorldHandler helloWorldHandler) {
        return
                route(GET("/hello")
                                .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)),
                        helloWorldHandler::helloWorld);
    }

    @Bean
    public RouterFunction<ServerResponse> hello(HelloWorldHandler handler){
        return route(GET("/hello"),handler::helloWorld)
                .andRoute(GET("/hello1"),handler::hellWorld11);
    }

}
