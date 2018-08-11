package com.example.springbootwebflux.demo1.handler;


import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * Title:com.example.springbootwebflux.demo1.handler
 * Description: 功能处理类
 * Copyright: Copyright (c) 2018
 * Company: 北京思特奇信息技术股份有限公司
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/08/06  17:47
 */
@Component
public class HelloWorldHandler {

    /**
     * ServerResponse 是对响应的封装，可以设置响应状态，响应头，响应正文。
     * 比如 ok 代表的是 200 响应码、MediaType 枚举是代表这文本内容类型、返回的是 String 的对象。
     * 这里用 Mono 作为返回对象，是因为返回包含了一个 ServerResponse 对象，而不是多个元素。
     * Flux返回多个元素
     *
     * @param request
     * @return
     */
    public Mono<ServerResponse> helloWorld(ServerRequest request) {
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject("Hello, World!"));
    }

    public Mono<ServerResponse> hellWorld11(ServerRequest request){
        return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
                .body(BodyInserters.fromObject("Hello, hellWorld11!"));
    }

    public Mono<String> hello(){
        return Mono.just("noooooo");
    }
}