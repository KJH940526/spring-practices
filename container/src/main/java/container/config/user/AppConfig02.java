package container.config.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import container.user.User;


@Configuration   //설정 클래스임을 알려주는 어노테이션!!
public class AppConfig02 {
	
	@Bean
	public User user() {
		System.out.println("22222222222222");
		return new User("마이콜");
	}

}
