package test;

import org.springframework.context.annotation.ComponentScan;
import test.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("test")
public class SpringDConfig {

    @Bean
    public User user(){
        return new User();
    }
}
