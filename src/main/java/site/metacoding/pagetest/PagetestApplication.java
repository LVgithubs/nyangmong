package site.metacoding.pagetest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class PagetestApplication {

	public static void main(String[] args) {
		SpringApplication.run(PagetestApplication.class, args);
	}
}