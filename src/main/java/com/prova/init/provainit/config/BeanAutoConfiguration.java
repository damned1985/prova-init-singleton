package com.prova.init.provainit.config;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.prova.init.provainit.config","com.prova.init.provainit.fagiolo"})
public class BeanAutoConfiguration {

	@Bean
	public Random getRandomGenerator() {
		Random rand = new Random(LocalDateTime.now().toEpochSecond(ZoneOffset.UTC));
		
		long seed = 0;
		int nextInt = rand.nextInt(90);
		for (int i = 0; i < Math.max(nextInt, 40); i++) {
			seed = rand.nextLong();
		}
		return new Random(seed);
	}
	
}
