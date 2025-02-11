package com.mlodovico.springmongdb.resources;

import com.mlodovico.springmongdb.models.dtos.UserDTO;
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
    public ResponseEntity<List<UserDTO>> findAll(){
        try {
            List<User> list = service.findAll();
            List<UserDTO> listDTO = list.stream().map(UserDTO::new).toList();

            return ResponseEntity.ok().body(listDTO);
        } catch (RuntimeException e){
            return ResponseEntity.noContent().build();
        }
    }
}