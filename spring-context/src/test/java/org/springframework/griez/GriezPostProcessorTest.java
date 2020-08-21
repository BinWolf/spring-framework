package org.springframework.griez;

import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

/**
 * Created on 2020/7/31 15:30.
 * @author Griez
 */
public class GriezPostProcessorTest {
	public static void main(String[] args) {
		XmlBeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("org/springframework/griez/spring-griez.xml"));
		BeanFactoryPostProcessor bfpp = (BeanFactoryPostProcessor) beanFactory.getBean("bfpp");
		bfpp.postProcessBeanFactory(beanFactory);
		System.out.println(beanFactory.getBean("griez"));
	}
}
