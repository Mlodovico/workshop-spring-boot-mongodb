package com.mlodovico.springmongdb.repositories;

import com.mlodovico.springmongdb.domains.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
