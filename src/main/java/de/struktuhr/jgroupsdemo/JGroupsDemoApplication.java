package de.struktuhr.jgroupsdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class JGroupsDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JGroupsDemoApplication.class, args);
	}

}
