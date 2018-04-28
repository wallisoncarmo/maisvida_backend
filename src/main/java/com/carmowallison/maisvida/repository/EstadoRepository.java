package com.carmowallison.maisvida.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carmowallison.maisvida.domain.Estado;

@Repository
public interface EstadoRepository extends MongoRepository<Estado, String> {
		
}
