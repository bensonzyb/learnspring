package com.spring;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @author by ben
 * @Description TODO
 * @Date 2020/12/18
 */
public class SpringApplicationContext {
    private  static ConcurrentHashMap<String,BeanDefinition> concurrentHashMap=new ConcurrentHashMap<String, BeanDefinition>();
    private  static ConcurrentHashMap<String,Object> singleObjects=new ConcurrentHashMap<String, Object>();

    public  SpringApplicationContext(Class configClass) throws ClassNotFoundException {
        //扫描类
        List<Class> list = scan(configClass);
        //装载单例
        for (Class clazz:list){
             if (clazz.isAnnotationPresent(Component.class)){
                 BeanDefinition beanDefinition =new BeanDefinition();
                 beanDefinition.setBeanClass(clazz);
                 Component component = (Component) clazz.getAnnotation(Component.class);
                 String beanName= component.value();
                if(clazz.isAnnotationPresent(Scope.class)){
                    Scope scope = (Scope) clazz.getAnnotation(Scope.class);
                    beanDefinition.setSore(scope.value());
                }else{
                    beanDefinition.setSore("singleton");
                }
                concurrentHashMap.put(beanName,beanDefinition);
             }
        }
        for(String beanName:concurrentHashMap.keySet()){
            BeanDefinition beanDefinition =  concurrentHashMap.get(beanName);
            if(beanDefinition.getSore().equals("singleton")){
                //生成bean
                Object bean = CreateBean(beanDefinition);
                singleObjects.put(beanName,bean);
            }
        }
    }

    private Object CreateBean(BeanDefinition beanDefinition) {
        Class clazz = beanDefinition.getBeanClass();
        try {
            //实例化
            Object bean = clazz.getDeclaredConstructor().newInstance();
            //填充属性
            Field[] fields = clazz.getDeclaredFields();
            for(Field f:fields){
                if(f.isAnnotationPresent(Autowired.class)){
                    Object userService = getBean(f.getName());
                    f.setAccessible(true);
                    f.set(bean,userService);
                }
            }
            return bean;
            //初始化
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    private List<Class> scan(Class configClass) throws ClassNotFoundException {
        List<Class> list =new ArrayList<Class>();
        if(configClass.isAnnotationPresent(ComponentScan.class)){
            //获取指定的注解类，获取扫描路径
            ComponentScan  componentScan = (ComponentScan) configClass.getAnnotation(ComponentScan.class);
            String scanPath = componentScan.value();
            System.out.println(scanPath);//com.zyb.service
            //扫描的路径，装载类
            //获取当前线程的装载类
            ClassLoader classLoader = SpringApplicationContext.class.getClassLoader();
            //是需要一个目录（com/zyb/service）
            scanPath= scanPath.replace(".","/");
            System.out.println(scanPath);
            URL resource = classLoader.getResource(scanPath);
            //获取目录对象(当前目录下的所有文件)
            File file = new File(resource.getFile());
            File [] files = file.listFiles();
            for (File f :files){
                String fileName = f.getName().split("\\.")[0];
                String loadPath = scanPath+"/"+fileName;
                loadPath= loadPath.replace("/",".");
                System.out.println(loadPath);
                Class<?> clazz = classLoader.loadClass(loadPath);
                list.add(clazz);
            }
        }
        return  list;
    }

    public  Object getBean(String beanName){
        BeanDefinition beanDefinition = concurrentHashMap.get(beanName);
        if(beanDefinition.getSore().equals("prototype")){
           return  CreateBean(beanDefinition);
        }else{
            Object bean = singleObjects.get(beanName);
            if(bean==null){
                Object o = CreateBean(beanDefinition);
                singleObjects.put(beanName,o);
                return  o;
            }
            return  bean;
        }
    }
}

