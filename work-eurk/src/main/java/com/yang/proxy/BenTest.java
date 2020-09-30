package com.yang.proxy;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;

import java.util.concurrent.CompletableFuture;

public class BenTest {
    public static void main(String[] args) {
//        BeanFactory beanFactory = new ClassPathXmlApplicationContext("applicationContext.xml");
//        beanFactory.getBean("");
//        BeanFactory factory = new XmlBeanFactory(new FileSystemResource("web/WEB-INF/classes/applicationContext.xml"));
        CompletableFuture future = new CompletableFuture();
        future.whenComplete((v, t) -> {
            if (t == null) {
                System.out.println(t);
            } else {
                System.out.println("异常");
            }
        });
        System.out.println(123);

    }
}
