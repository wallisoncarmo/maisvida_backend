package com.carmowallison.maisvida.repositoties;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carmowallison.maisvida.domain.Medico;

@Repository
public interface MedicoRepository extends MongoRepository<Medico, String> {
		
}
