package com.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Import({MyImportSelector.class,com.aop.Cat.class,com.aop.MyImportBeanDefinitionRegister.class})
public class SpringConfigtion {

    @Bean
    public MyCaculator myCaculator(){
        return new MyCaculator();
    }
}
