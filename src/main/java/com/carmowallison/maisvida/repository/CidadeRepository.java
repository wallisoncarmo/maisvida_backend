package com.carmowallison.maisvida.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.carmowallison.maisvida.domain.Cidade;

@Repository
public interface CidadeRepository extends MongoRepository<Cidade, String> {
		
}
