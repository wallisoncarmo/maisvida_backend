package com.carmowallison.maisvida.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carmowallison.maisvida.domain.Especialidade;

@Repository
public interface EspecialidadeRepository extends MongoRepository<Especialidade, String> {
		
}
