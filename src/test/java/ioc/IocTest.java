package ioc;

import com.ioc.config.SpringConfig;
import com.ioc.entity.Person;
import com.ioc.entity.User;
import com.ioc.entity.Wife;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author by ben
 * @Description TODO
 * @Date 2021/3/20
 */
public class IocTest {

    AnnotationConfigApplicationContext ioc;
    @Test
    public void test(){

        ioc = new AnnotationConfigApplicationContext(SpringConfig.class);
        User user= (User) ioc.getBean("user");
        System.out.println(user.toString());
    }


    @Test
    public void test2(){

        ioc = new AnnotationConfigApplicationContext(SpringConfig.class);
        Person person= (Person) ioc.getBean(Person.class);
        System.out.println(person.getName());

        Wife wife= (Wife) ioc.getBean(Wife.class);
        System.out.println(wife.getName());
    }


    @Test
    public void test3(){

        ioc = new AnnotationConfigApplicationContext(SpringConfig.class);
        //Person person= (Person) ioc.getBean(Person.class);
        //System.out.println(person.getName());

        Wife wife= (Wife) ioc.getBean(Wife.class);
        System.out.println(wife.getName());

        Wife wife2= (Wife) ioc.getBean("wife2");
        System.out.println(wife2.getName());
    }
}
