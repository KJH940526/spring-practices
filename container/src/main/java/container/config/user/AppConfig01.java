package container.config.user;

import org.springframework.context.annotation.Bean;

import container.user.User;

public class AppConfig01 {
	
	@Bean
	public User user() {
		System.out.println("1111111111");
		return new User();
	}

}
