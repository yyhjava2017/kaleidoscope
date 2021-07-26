package test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import test.entity.Register;
import test.entity.Service;
import test.entity.User;

import java.util.List;
import java.util.Scanner;

public class Test {

    @org.junit.Test
    public void test1(){
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringDConfig.class);
        BeanFactory bf = ((AnnotationConfigApplicationContext)context).getDefaultListableBeanFactory();
        BeanDefinition bd = new RootBeanDefinition(Register.class);
        ((DefaultListableBeanFactory)bf).registerBeanDefinition("registry",bd);
        User u = (User) context.getBean("user");
        Service s = (Service) context.getBean("tservice");
        Register r = (Register) context.getBean("registry");
        System.out.println(u);
        System.out.println(s);
        System.out.println(r);
    }

    public List<?> getNUm(){
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
    }
}
