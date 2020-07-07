package com.griez;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import java.time.LocalDateTime;
import java.time.temporal.TemporalField;

/**
 * Created on 2020/6/6 15:48.
 * @author Griez
 */
public class GriezTest {

	@Test
	public void testBean(){
		BeanFactory beanFactory = new XmlBeanFactory(new ClassPathResource("com/griez/spring-griez.xml"));
		GriezBean bean = beanFactory.getBean(GriezBean.class);
		System.out.println(bean.getName());


	}

}
