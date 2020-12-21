package com.spring;

/**
 * @author by ben
 * @Description TODO
 * @Date 2020/12/20
 */
public class BeanDefinition {
    private  String sore ;
    private  Class beanClass;



    public String getSore() {
        return sore;
    }

    public void setSore(String sore) {
        this.sore = sore;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }
}
