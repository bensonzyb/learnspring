package com.ioc.config;

import com.ioc.entity.Person;
import com.ioc.entity.Wife;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author by ben
 * @Description TODO
 * @Date 2021/3/16
 */
public class myImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{Person.class.getName(), Wife.class.getName()};
    }
}
