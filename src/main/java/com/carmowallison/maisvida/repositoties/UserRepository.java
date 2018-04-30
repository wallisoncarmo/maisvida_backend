package com.carmowallison.maisvida.repositoties;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carmowallison.maisvida.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
	User findByEmailContaining(String text);
	
}
