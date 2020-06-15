import com.spring.TestBean;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @创建人 lixiangnan
 * @创建时间 2019/11/4
 * @描述
 */
public class Test {

	@org.junit.Test
	public void testXmlLoad(){
//		BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
//		TestBean bean = (TestBean)beanFactory.getBean("testBean");
//		System.out.println(bean.getHello());

		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("spring-config.xml"));
		TestBean bean = (TestBean)beanFactory.getBean("testBean");
		System.out.println(bean.getHello());
	}
}
