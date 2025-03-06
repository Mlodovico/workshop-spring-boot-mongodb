package com.mlodovico.springmongdb.resources;

import com.mlodovico.springmongdb.domains.Post;
import com.mlodovico.springmongdb.domains.User;
import com.mlodovico.springmongdb.models.dtos.UserDTO;
import com.mlodovico.springmongdb.services.PostService;
import com.mlodovico.springmongdb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id){
        try {
            Post post = service.findById(id);

            return ResponseEntity.ok().body(post);
        } catch (RuntimeException e){
            return ResponseEntity.noContent().build();
        }
    }

}