package aop;

import com.aop.entity.AopUser;
import com.aop.service.AopUserService;
import com.aop.service.impl.AopUserServiceCglib;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author by ben
 * @Description TODO
 * @Date 2021/3/22
 */
public class AopUserTest {

  @Test
  public  void test() throws Exception {
      ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:/aop/spring-aop.xml");
      /**
       * 1.通过接口接口获取动态代理类
       * 2.通过名字获取动态代理类，但必须转换成接口，应为动态代理类也是实现了该接口
       */
      //1.class com.sun.proxy.$Proxy20  输出的是JDK所代理的一个动态代理类 （由于是用接口方式实现的）
      //当贝代理的类实现了接口，就是使用jdk代理
      AopUserService aopUserService = (AopUserService) applicationContext.getBean(AopUserService.class);
      System.out.println("1:"+aopUserService.getClass());
      //2.通过名字获取
      AopUserService aopUserService2 = (AopUserService) applicationContext.getBean("aopUserServiceImpl");
      System.out.println("2:"+aopUserService2.getClass());

      //cglib动态代理:class com.aop.service.impl.AopUserServiceCglib$$EnhancerBySpringCGLIB$$c24b4486
     AopUserServiceCglib aopUserServiceCglib = (AopUserServiceCglib) applicationContext.getBean(AopUserServiceCglib.class);
     System.out.println(aopUserServiceCglib.getClass());

      aopUserService.select(2);
      System.out.println("select ----------end ");
      //aopUserService.addUser(new AopUser());
      System.out.println("addUser ----------end ");
      //aopUserService2.addUser(new AopUser());

  }


}
