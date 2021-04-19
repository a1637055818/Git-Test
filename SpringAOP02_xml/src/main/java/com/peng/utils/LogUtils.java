package com.peng.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author 16370
 * @create 2021-03-28 下午 3:03
 */
//@Aspect
//@Component
//@Order(1) //使用order改变切面顺序；数值越小，优先级越高
public class LogUtils {

    /**
     *抽取可重用的切入点表达式：
     *  1.声明一个没有实现的返回void的空方法
     *  2.给方法上标注@Pointcut
     *
     */
   // @Pointcut("execution(public  int com.peng.impl.MyMathCalculator.*(int, int))")
    public void myPoint(){

    };

    /**
     * 告诉Spring每个方法都什么时候运行;
     * @Before:在目标方法之前  前置通知
     * @After:在目标方法结束之后 后置通知
     * @AfterReturning：目标方法正常返回之后 返回通知
     * @AfterThrowing:在目标方法出异常之后运行 异常通知
     * @Around:环绕 环绕通知
     *
     *
     */
    //执行目标方法之前运行:写切入点表达式
    //execution(访问权限符 返回值类型 方法签名)
   // @Before("myPoint()")
    public static void logStart(JoinPoint joinPoint){
        //获取到目标方法运行时使用的参数
        Object[] args = joinPoint.getArgs();
        //获取方法签名
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println(name+"LogUtils方法开始执行，参数列表是->"+ Arrays.asList(args));
    }

    /**
     * 切入点表达式的写法：
     * 固定格式:execution(权限修饰符 返回值类型 方法的全类名(参数表))
     *
     *  通配符：
     *      *：
     *          1.匹配一个或者多个字符execution(public int com.peng.impl.MyMath*.*(int, int)
     *          2.匹配任意一个参数:execution(public int com.peng.impl.MyMathCalculator.*(int, *)
     *              第一个是int类型，第二个参数参数类型(匹配两个参数)
                3.只能匹配一层路径
                4.权限位置*不能表示任意权限，权限位置不写就行
                    public【可选的】
     *      ..：
     *          1.匹配任意多个参数,任意参数类型
     *          execution(public int com.peng.impl.MyMathCalculator.*(..))
     *          2.匹配任意多层路径
     *          execution(public int com.peng..MyMathCalculator.*(int, int))
     *
     *   记住两种：
     *   最精确的:  execution(public int com.peng.impl.MyMathCalculator.add(int, int)
     *   最模糊的： execution(* *(..)),千万别写
     *
     *  1.告诉Spring这个res用来接受返回值
     *  returning = "res"
     *  2.告诉Spring这个e用来接受异常
     *  throwing = "e"
     *  3.Exception e：指定通知方法可以接受哪些异常
     */
    //正常结束之后运行
   // @AfterReturning(value = "myPoint()",returning = "res")
    public static void logReturn(JoinPoint joinPoint,Object res){
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println(name+"LogUtils方法正常执行完成，结果是...."+res);
    }

    /**
     * 我们可以通知方法运行的时候，拿到目标方法的详细信息
     * 1.只需要为通知方法的参数列表上写一个参数:Joinpoint joinpoint
     * 封装了目标方法的详细信息
     *
     */
    //方法出现异常执行
   // @AfterThrowing(value = "myPoint()",throwing = "e")
    public static void logException(JoinPoint joinPoint,Exception e){
        System.out.println(joinPoint.getSignature().getName()+"LogUtils出现异常logException...."+e);
    }

    /**
     * Spring对通知方法的要求不严格
     * 唯一要求的就是方法的参数列表一定不能乱写
     *  通知方法时Spring利用反射调用，
     *  而每次方法调用得确定这个方法的参数列表的值
     *  参数表上的每一个参数，Spring都得知道是什么
     *  不知道的参数一定告诉Spring这是什么
     * @param joinPoint
     */
    //方法结束的时候执行
   // @After("myPoint()")
    public static void logEnd(JoinPoint joinPoint){
        Signature signature = joinPoint.getSignature();
        String name = signature.getName();
        System.out.println(name+"LogUtils方法结束logEnd....");
    }

    /**
     * @Around: 环绕通知是Spring中最强大的通知
     * @Around: 动态代理
     * try{
     *      //前置通知
     *     method.invoke();
     *     //返回通知
     * }catch(e){
     *     //异常通知
     * }finally{
     *     //后置通知
     * }
     * 四合一通知就是环绕通知：
     * 环绕通知中 有一个参数ProceedingJoinPoint pjp
     *
     * 环绕通知：是优先于普通通知执行，执行顺序
     *
     * 【普通前置】
     *
     * {
     *
     *     try{
     *     环绕前置
     *
     *     环绕执行，目标方法执行
     *
     *     环绕返回
     *     }catch{
     *       出现异常环绕异常
     *     }finally{
     *       环绕后置
     *     }
     *
     *
     *
     * }
     *
     * 【普通后置】
     * 【普通方法返回/方法异常通知】
     *
     *  新的顺序
     *      (环绕前置-》普通前置)-》目标方法执行-》
     *      环绕返回/出现异常-》环绕后置
     *      -》普通后置-》普通返回/异常
     *
     *
     */
   // @Around(value = "myPoint()")
    public Object myAround(ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        Signature signature = pjp.getSignature();
        Object proceed = null;
        try {
            System.out.println("环绕前置通知方法名"+signature.getName()+"方法开始");
            //就是利用反射调用目标方法即可.就是method.invoke(obj,args)
            proceed = pjp.proceed(args);
            System.out.println("环绕返回通知返回值"+proceed);
        } catch (Exception e) {
            System.out.println("环绕异常通知，出现异常"+e);
            //为了让外界能感知这个异常，要将异常抛出去
            throw  new RuntimeException(e);
        } finally {
            System.out.println("环绕后置通知"+signature.getName()+"最终结束");
        }

        //反射调用后的返回值也一定返回出去
        return proceed;
    }

}
