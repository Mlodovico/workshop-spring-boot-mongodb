package com.mlodovico.springmongdb.services;

import com.mlodovico.springmongdb.domains.Post;
import com.mlodovico.springmongdb.domains.User;
import com.mlodovico.springmongdb.models.dtos.UserDTO;
import com.mlodovico.springmongdb.repositories.PostRepository;
import com.mlodovico.springmongdb.repositories.UserRepository;
import com.mlodovico.springmongdb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id) {
        Post post = repo.findById(id).orElse(null);

        if (post == null) {
            throw new ObjectNotFoundException("Status: 404, Post not found");
        }

        return post;
    }
}
