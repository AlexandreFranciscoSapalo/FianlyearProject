package com.eventSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eventSystem.config.Bootstrap;
import com.eventSystem.controllers.web.IndexController;


@SpringBootApplication
public class EventSystemApplication implements ApplicationRunner {

	private Bootstrap bootstrap;

	@Autowired
	public void setBootstrap(Bootstrap bootstrap) {
		this.bootstrap = bootstrap;
	}

	public static void main(String[] args) {
		SpringApplication.run(EventSystemApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		IndexController.log.info("before setup");
		this.bootstrap.start();
		IndexController.log.info("after setup");
	}
}
