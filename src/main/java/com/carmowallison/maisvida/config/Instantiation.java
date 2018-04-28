package com.carmowallison.maisvida.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.carmowallison.maisvida.domain.User;
import com.carmowallison.maisvida.domain.enums.Perfil;
import com.carmowallison.maisvida.repository.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private BCryptPasswordEncoder bc;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		userRepository.deleteAll();
		
		User wallison = new User(null, "Wallison", "wallisoncarmo@gmail.com", true, bc.encode("123"));
		wallison.addPerfil(Perfil.ADMIN);
		
		User yasmin = new User(null, "yasmin", "yasmin@gmail.com",  false,bc.encode("123"));
		User lucy = new User(null, "lucy", "lucy@gmail.com",  true,bc.encode("123"));
		
		userRepository.saveAll(Arrays.asList(wallison,yasmin,lucy));
		
	}

}
