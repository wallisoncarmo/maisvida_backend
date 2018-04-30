package com.carmowallison.maisvida.repositoties;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carmowallison.maisvida.domain.Estado;

@Repository
public interface EstadoRepository extends MongoRepository<Estado, String> {
		
}
