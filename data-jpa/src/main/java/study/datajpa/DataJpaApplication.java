package study.datajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;
import java.util.UUID;

@EnableJpaAuditing
@SpringBootApplication
public class DataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataJpaApplication.class, args);
	}

	@Bean
	public AuditorAware<String> auditorProvider(){
		//interface에서 메소드가 하나면 오버라이드 생략가능 람다로!
		// 스프링 시큐리티 컨텍스트, 세션정보 가져와서 걔 아이디 꺼내야함
		// 아니면 http세션에서 꺼내서 확인하거나 그렇게
		return () -> Optional.of(UUID.randomUUID().toString());
	}
}
