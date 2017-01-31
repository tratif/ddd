package com.tratif.ddd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import reactor.Environment;
import reactor.bus.EventBus;

@SpringBootApplication
public class DddDemoApplication {

	@Bean
    Environment env() {
        return Environment.initializeIfEmpty()
                          .assignErrorJournal();
    }
	
	@Bean
	EventBus eventBus(Environment env) {
		return EventBus.create(env, Environment.THREAD_POOL);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(DddDemoApplication.class, args);
	}
}
