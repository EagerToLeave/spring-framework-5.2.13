package cn.roy.spring.circulardependencies;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author smlz
 */
public class MainClass {


	public static void main(String[] args) {
		//创建IOC容器
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				MainConfig.class);

//		context.getBeanFactory().get
		InstanceA instanceA = (InstanceA) context.getBean("instanceA");
		InstanceB instanceB = (InstanceB) context.getBean("instanceB");

		System.out.println(instanceA.getInstanceB());
		System.out.println(instanceB.getInstanceA());

		// 自定义BeanDefinition
		/*AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition()
				.getBeanDefinition();
		beanDefinition.setBeanClass(User.class);

		// 将bd注册到beanFactory中
		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
		beanFactory.registerBeanDefinition("user", beanDefinition);

		//获取bean
		System.out.println(beanFactory.getBean("user"));*/

		context.publishEvent("saas");


	}
}
