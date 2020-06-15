package com.lixn;

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
		context.register(AnnotationTest.class);
		context.refresh();
		AnnotationTest test = (AnnotationTest)context.getBean("test");
		System.out.println(test);
	}
}
