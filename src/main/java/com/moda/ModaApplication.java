package com.moda;


import com.moda.controller.IndexController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

import com.moda.videochat.MyWebSocketConfigurator;


@Configuration
@EnableAutoConfiguration
@EnableWebSocket
@Import(MyWebSocketConfigurator.class)
@SpringBootApplication(scanBasePackages={
		"com.moda.model", "com.moda.repository","com.moda.repository.KullaniciRepository.java"})
@ComponentScan(basePackageClasses = IndexController.class)
public class ModaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModaApplication.class, args);
	}
}
