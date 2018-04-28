package com.carmowallison.maisvida.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.carmowallison.maisvida.security.UserSS;

public class UserSService {

	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}

}
