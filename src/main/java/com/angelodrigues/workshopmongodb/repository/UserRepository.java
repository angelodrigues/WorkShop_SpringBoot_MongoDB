package com.angelodrigues.workshopmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.angelodrigues.workshopmongodb.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User,String>{
    
}