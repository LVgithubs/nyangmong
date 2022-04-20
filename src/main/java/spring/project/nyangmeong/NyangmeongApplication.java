package spring.project.nyangmeong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class NyangmeongApplication {

	public static void main(String[] args) {
		SpringApplication.run(NyangmeongApplication.class, args);
	}
}