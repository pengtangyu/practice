package org.practice.thinking.in.spring.bean.definition;

import org.practice.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Bean 别名示例
 */
public class BeanAliasDemo {
    public static void main(String[] args) {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("classpath:/META-INF/bean-definitions-context.xml");
        // 通过别名获取bean
        User user = beanFactory.getBean("user", User.class);
        User ptyUser = beanFactory.getBean("pty-user", User.class);
        System.out.println("ptyUser是否与user bean相同" + (user == ptyUser));
    }
}
