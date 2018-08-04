package com.dangqp.springboot_demo;

import com.dangqp.springboot_demo.demo.FooProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationContext;

import java.util.List;


@SpringBootApplication
public class SpringbootDemoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringbootDemoApplication.class, args);
		ApplicationContext context = SpringApplication.run(SpringbootDemoApplication.class, args);

		//通过最新的Binder就可以这样来拿配置信息了
		Binder binder = Binder.get(context.getEnvironment());
		// 绑定简单配置
		FooProperties foo = binder.bind("com.didispace", Bindable.of(FooProperties.class)).get();
		System.out.println(foo.getFoo());
		// 绑定List配置
		List<String> url = binder.bind("spring.my-example.url",Bindable.listOf(String.class)).get();
		url.forEach(p-> System.out.println(p));
	}
}
