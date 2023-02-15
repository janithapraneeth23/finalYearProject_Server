package com.janitha.videoenhancer.serverAtCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan
@EntityScan("com.janitha.videoenhancer.serverAtCloud.formLogin.Model")
@EnableJpaRepositories
public class ServerAtCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerAtCloudApplication.class, args);
	}

}
