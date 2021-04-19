package com.peng.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author 16370
 * @create 2021-03-28 下午 10:25
 */
@Aspect
@Component
public class ValidateApsect {

    @Pointcut("execution(public  int com.peng.impl.MyMathCalculator.*(int, int))")
    public void myPoint(){

    };

    @Before("myPoint()")
    public static void logStart(JoinPoint joinPoint){
        //获取到目标方法运行时使用的参数
        Object[] args = joinPoint.getArgs();
        //获取方法签名
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println(name+"方法开始执行，参数列表是->"+ Arrays.asList(args));
    }

    @AfterReturning(value = "myPoint()",returning = "res")
    public static void logReturn(JoinPoint joinPoint,Object res){
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println(name+"方法正常执行完成，结果是...."+res);
    }

    @AfterThrowing(value = "myPoint()",throwing = "e")
    public static void logException(JoinPoint joinPoint,Exception e){
        System.out.println(joinPoint.getSignature().getName()+"出现异常logException...."+e);
    }

    @After("myPoint()")
    public static void logEnd(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println(name+"方法结束logEnd....");
    }


}
