package com.carmowallison.maisvida.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.carmowallison.maisvida.domain.User;
import com.carmowallison.maisvida.repositoties.UserRepository;
import com.carmowallison.maisvida.security.UserSS;

@Service
public class UserDetailsServicesImpl implements UserDetailsService {
	@Autowired
	private UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		 User obj = repo.findByEmailContaining(email);
		if (obj == null) {
			throw new UsernameNotFoundException(email);
		}
		return new UserSS(obj.getId(), obj.getEmail(), obj.getSenha(), obj.getPerfis());
	}

}
