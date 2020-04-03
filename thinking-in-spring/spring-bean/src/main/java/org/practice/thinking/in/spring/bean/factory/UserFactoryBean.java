package org.practice.thinking.in.spring.bean.factory;

import org.practice.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.FactoryBean;

/**
 * {@link org.practice.thinking.in.spring.ioc.overview.domain.User} Bean的 {@link org.springframework.beans.factory.FactoryBean}实现
 */
public class UserFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        return User.createUser();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}
