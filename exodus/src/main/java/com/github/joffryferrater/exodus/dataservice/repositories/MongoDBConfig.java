package com.github.joffryferrater.exodus.dataservice.repositories;

import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;

/**
 * Mongo DB Configuration class.
 * 
 * @author Joffry Ferrater
 *
 */
@EnableMongoRepositories
public class MongoDBConfig {

	private static final String LOCALHOST = "localhost";
	private static final String ENTITIES = "entities";
	
	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(new MongoClient(LOCALHOST), ENTITIES);
	}
}
