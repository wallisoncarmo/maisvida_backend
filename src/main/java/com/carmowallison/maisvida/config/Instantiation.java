package com.carmowallison.maisvida.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.carmowallison.maisvida.domain.User;
import com.carmowallison.maisvida.repository.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User wallison = new User(null, "Wallison", "Carmo", "wallisoncarmo@gmail.com", true, true,"123");
		User yasmin = new User(null, "yasmin", "Costa", "yasmin@gmail.com", true, false,"123");
		User lucy = new User(null, "lucy", "Oliveira", "lucy@gmail.com", false, true,"123");
		
		userRepository.saveAll(Arrays.asList(wallison,yasmin,lucy));
		
	}

}
