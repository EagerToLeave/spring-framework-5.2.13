package cn.roy.spring.circulardependencies;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by smlz on 2019/5/29.
 */
@Configuration
@ComponentScan(basePackages = {"cn.roy.spring"})
public class MainConfig {

	@Bean
	public ApplicationListener<?> applicationListener() {
		return new ApplicationListener<ApplicationEvent>() {
			@Override
			public void onApplicationEvent(ApplicationEvent event) {
				System.out.println("发布事件监听");
			}
		};
	}

}
