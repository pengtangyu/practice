package org.practice.thinking.in.spring.bean.definition;

import org.practice.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionReaderUtils;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * 注解 BeanDefinition示例
 */
@Import(AnnotationBeanDefinitionDemo.Config.class) // 1.通过 @import导入
public class AnnotationBeanDefinitionDemo {
    public static void main(String[] args) {
        // 创建BeanFactory容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        // 注册Configuration Class（配置类）
        applicationContext.register(AnnotationBeanDefinitionDemo.class);

        // 通过 BeanDefinition 注册API实现
        // 1.通过Bean命名的注册方式
        registerUserBeanDefinition(applicationContext, "pengtangyu");
        // 2.非命名Bean的注册方式
        registerUserBeanDefinition(applicationContext);

        // 启动应用上下文
        applicationContext.refresh();
        // 依赖查找
        System.out.println("Config 类型的所有Beans" + applicationContext.getBeansOfType(Config.class));
        System.out.println("User 类型的所有Beans" + applicationContext.getBeansOfType(User.class));


        // 显式的关闭Spring应用上下文
        applicationContext.close();
    }

    /**
     * 命名Bean的注册方式
     *
     * @param registry
     * @param beanName
     */
    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry, String beanName) {
        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(User.class);
        beanDefinitionBuilder
                .addPropertyValue("id", 1L)
                .addPropertyValue("name", "pty");

        // 判断 beanName 参数存在时
        if (StringUtils.hasText(beanName)) {
            registry.registerBeanDefinition(beanName, beanDefinitionBuilder.getBeanDefinition());
        } else {
            BeanDefinitionReaderUtils.registerWithGeneratedName(beanDefinitionBuilder.getBeanDefinition(), registry);
        }
    }

    public static void registerUserBeanDefinition(BeanDefinitionRegistry registry) {
        registerUserBeanDefinition(registry, null);
    }

    // 2.通过 @Component方式
    @Component // 定义当前类作为 Spring Bean（组件）
    public static class Config {

        // 1.通过 @Bean 方式定义

        /**
         * 通过JAVA注解的方式定义了一个Bean
         *
         * @return
         */
        @Bean(name = {"user", "pty-user"})
        public User user() {
            User user = new User();
            user.setId(1L);
            user.setName("PTY");
            return user;
        }
    }

}
