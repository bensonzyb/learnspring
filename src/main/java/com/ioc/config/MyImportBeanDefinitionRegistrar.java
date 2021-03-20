package com.ioc.config;

import com.ioc.entity.Wife;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.stereotype.Component;

/**
 * @author by ben
 * @Description TODO
 * @Date 2021/3/17
 */
@Component
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        GenericBeanDefinition  genericBeanDefinition = new GenericBeanDefinition();
        genericBeanDefinition.setBeanClass(Wife.class);
        registry.registerBeanDefinition("wife2",genericBeanDefinition);
    }

}
