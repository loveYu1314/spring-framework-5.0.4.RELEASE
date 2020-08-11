package com.spring.circularDependency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @创建人 lixiangnan
 * @创建时间 2020/8/11 21:27
 * @描述
 */
@Component
public class BeanA {

	@Autowired
	private BeanB beanB;
//
//	@Autowired
//	private BeanA beanA;
//	public BeanA(BeanB beanB){}
}
