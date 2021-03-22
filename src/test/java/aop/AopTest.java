package aop;

import com.aop.Calculator;
import com.aop.Icalculator;
import com.aop.MyInvocationHandler;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author by ben
 * @Description 测试动态代理类
 * @Date 2021/3/21
 *
 * 总结：
 * 1.JDk代理缺点一定要被代理的类实现了接口实现，才能实现动态代理
 * 2.而Spring AOP原来就是会判断被代理的类是否实现了接口，如果有就用JDK动态代理实现，
 * 如果没有则用cglib动态来实现，并且自动将实例化得实体类自动交给IOC容器管理
 * （总结：动态实现代理，跟IOC结合一起）
 */
public class AopTest {

    @Test
    public void test(){

        /**ClassLoader loader,
        Class<?>[] interfaces,
        InvocationHandler h
         **/
        ClassLoader loader = Icalculator.class.getClassLoader();
        Class<?>[] interfaces = new Class[]{Icalculator.class};
        MyInvocationHandler handler =new MyInvocationHandler(new Calculator());
        //创建Jdk动态代理类
        Icalculator icalculator = (Icalculator) Proxy.newProxyInstance(loader,interfaces, handler);
        System.out.println(icalculator.add(8,2));

    }


    /**
     * 创建一个公共的JDK动态代理对象,保证代理类实现了接口
     */
    public static Object createProxy(Object needProxy){
        /**ClassLoader loader,
         Class<?>[] interfaces,
         InvocationHandler h
         **/
        ClassLoader loader = needProxy.getClass().getClassLoader();
        System.out.println("loader:"+loader.toString());
        Class<?>[] interfaces = needProxy.getClass().getInterfaces();
        System.out.println("interfaces:"+interfaces.toString());
        MyInvocationHandler handler =new MyInvocationHandler(needProxy);
        //创建Jdk动态代理类
        Object o =  Proxy.newProxyInstance(loader,interfaces, handler);
        return o;
    }

    @Test
    public void testProxy(){
        //代理计算器代理类
        Icalculator icalculator = (Icalculator) AopTest.createProxy(new Calculator());
        System.out.println(icalculator.add(8,8));

    }









}
