package com.mlodovico.springmongdb.resources;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.mlodovico.springmongdb.domains.User;
import com.mlodovico.springmongdb.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
        try {
            List<User> list = service.findAll();

            return ResponseEntity.ok().body(list);
        } catch (RuntimeException e){
            return ResponseEntity.noContent().build();
        }
    }
}