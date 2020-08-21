package org.springframework.griez;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.StringValueResolver;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created on 2020/7/31 15:15.
 * @author Griez
 */
public class GriezBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	private Set<String> obscenities;

	public GriezBeanFactoryPostProcessor() {
		this.obscenities = new HashSet<>();
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		String[] names = beanFactory.getBeanDefinitionNames();
		for (String beanName : names) {
			BeanDefinition bd = beanFactory.getBeanDefinition(beanName);
			StringValueResolver valueResolver = strVal -> (isObscenity(strVal) ? "******" : strVal);
			BeanDefinitionVisitor visitor = new BeanDefinitionVisitor(valueResolver);
			visitor.visitBeanDefinition(bd);
		}
	}

	public boolean isObscenity(Object value) {
		String potentialObscenity = value.toString().toUpperCase();
		return this.obscenities.contains(potentialObscenity);
	}

	public void setObscenities(Set<String> obscenities) {
		this.obscenities.clear();
		this.obscenities = obscenities.stream().map(String::toUpperCase).collect(Collectors.toSet());
	}
}
