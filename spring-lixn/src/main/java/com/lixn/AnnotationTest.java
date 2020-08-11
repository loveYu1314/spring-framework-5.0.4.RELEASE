package com.lixn;

import com.spring.circularDependency.BeanA;
import com.spring.circularDependency.BeanB;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @创建人 lixiangnan
 * @创建时间 2019/11/2
 * @描述
 */
@Component("test")
public class AnnotationTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(BeanA.class,BeanB.class);
		context.refresh();
		context.close();
//		BeanA beanA = (BeanA)context.getBean("beanA");
//		BeanB beanB = (BeanB)context.getBean("beanB");
//		System.out.println(beanA);
//		System.out.println(beanB);
	}
}
