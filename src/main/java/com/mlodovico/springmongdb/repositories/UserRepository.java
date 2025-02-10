package com.mlodovico.springmongdb.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.mlodovico.springmongdb.domains.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

}
