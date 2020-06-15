package com.lixn.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @创建人 lixiangnan
 * @创建时间 2020/6/13 9:29
 * @描述
 */
public class UserAware implements BeanNameAware,BeanClassLoaderAware,BeanFactoryAware {

	private ClassLoader classLoader;

	private BeanFactory beanFactory;

	@Override
	public void setBeanClassLoader(ClassLoader classLoader) {
		this.classLoader = classLoader;
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		this.beanFactory = beanFactory;
	}

	@Override
	public void setBeanName(String name) {
		System.out.println(name);
	}
}
