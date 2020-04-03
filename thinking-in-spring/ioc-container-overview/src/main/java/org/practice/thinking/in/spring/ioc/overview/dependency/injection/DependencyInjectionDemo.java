package org.practice.thinking.in.spring.ioc.overview.dependency.injection;

import org.practice.thinking.in.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 依赖注入示例
 * 1、通过名称的方式来查找
 * <p>
 * Spring依赖注入来源：
 * 1、自定义Bean
 * 2、内部容器所构建的Bean
 * 3、内部容器所构建的依赖
 */
public class DependencyInjectionDemo {

    public static void main(String[] args) {
        // 配置xml文件
        // 启动 Spring上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-injection-context.xml");
        UserRepository userRepository = beanFactory.getBean("userRepository", UserRepository.class);
        System.out.println(userRepository.getBeanFactory());
        System.out.println(userRepository.getBeanFactory() == beanFactory);

        ObjectFactory objectFactory = userRepository.getObjectFactory();
        System.out.println(objectFactory.getObject());
        System.out.println(objectFactory.getObject() == beanFactory);
    }


}
