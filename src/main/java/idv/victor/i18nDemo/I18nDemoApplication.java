package idv.victor.i18nDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "idv.victor.i18nDemo")
public class I18nDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(I18nDemoApplication.class, args);
	}

}
