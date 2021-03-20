package com.ioc.config;

import com.ioc.entity.Person;
import com.ioc.entity.Wife;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author by ben
 * @Description  返回多个指定的bean类型
 *
 */
public class myImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{Person.class.getName(), Wife.class.getName()};
    }
}
