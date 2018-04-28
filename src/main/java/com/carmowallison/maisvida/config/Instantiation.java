package com.carmowallison.maisvida.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.carmowallison.maisvida.domain.Estado;
import com.carmowallison.maisvida.domain.User;
import com.carmowallison.maisvida.domain.enums.Perfil;
import com.carmowallison.maisvida.repository.EstadoRepository;
import com.carmowallison.maisvida.repository.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
		
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private BCryptPasswordEncoder bc;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		// excluir todos a base
		userRepository.deleteAll();		
		estadoRepository.deleteAll();		
		
		//cria novamente a base
				
		// BLOCO USUARIOS	
		User wallison = new User(null, "Wallison", "wallisoncarmo@gmail.com", true, bc.encode("123"));
		wallison.addPerfil(Perfil.ADMIN);
		
		User yasmin = new User(null, "yasmin", "yasmin@gmail.com",  false,bc.encode("123"));
		User lucy = new User(null, "lucy", "lucy@gmail.com",  true,bc.encode("123"));
		
		userRepository.saveAll(Arrays.asList(wallison,yasmin,lucy));	
		
		// BLOCO ESTADOS
		Estado e1 = new Estado(null, "Distrito Federal", true);
		Estado e2 = new Estado(null, "Rio de Janeiro", true);
		Estado e3 = new Estado(null, "São Paulo", true);		
		
		estadoRepository.saveAll(Arrays.asList(e1,e2,e3));
		
		
	}

}
