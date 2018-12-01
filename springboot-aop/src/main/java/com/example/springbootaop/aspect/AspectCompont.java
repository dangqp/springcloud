package com.example.springbootaop.aspect;

import com.example.springbootaop.domain.ParamVO;
import com.example.springbootaop.domain.ResultVO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;

/**
 * Title:com.example.springbootaop.aspect
 * Description:
 * Copyright: Copyright (c) 2018
 * Company: 北京思特奇信息技术股份有限公司
 *
 * @author dangqp
 * @version 1.0
 * @created 2018/10/12  15:33
 */
@Configuration
@Aspect
public class AspectCompont {

    @Pointcut("execution(* com.example.springbootaop.service.*.*(..))")
    public void execAspectPoint() {
    }

    //执行方法前的拦截方法
    @Before("execAspectPoint()")
    public void doBeforeMethod(JoinPoint joinPoint) {
        System.out.println("我是前置通知，我将要执行一个方法了");
        //获取目标方法的参数信息
        Object[] obj = joinPoint.getArgs();
        for (Object argItem : obj) {
            System.out.println("---->now-->argItem:" + argItem);
            if (argItem instanceof ParamVO) {
                ParamVO paramVO = (ParamVO) argItem;
                paramVO.setInputParam("666666");
            }
            System.out.println("---->after-->argItem:" + argItem);
        }
    }

    /**
     * 后置返回通知
     * 这里需要注意的是:
     * 如果参数中的第一个参数为JoinPoint，则第二个参数为返回值的信息
     * 如果参数中的第一个参数不为JoinPoint，则第一个参数为returning中对应的参数
     * returning 限定了只有目标方法返回值与通知方法相应参数类型时才能执行后置返回通知，否则不执行，对于returning对应的通知方法参数为Object类型将匹配任何目标返回值
     */
    @AfterReturning(value = "execAspectPoint()",returning = "keys")
    public void doAfterReturningAdvice1(JoinPoint joinPoint, Object keys) {
        System.out.println("第一个后置返回通知的返回值：" + keys);
        if (keys instanceof ResultVO) {
            ResultVO resultVO = (ResultVO) keys;
            String message = resultVO.getMessage();
            resultVO.setMessage("通过AOP把值修改了 " + message);
        }
        System.out.println("修改完毕-->返回方法为:" + keys);
    }
}
