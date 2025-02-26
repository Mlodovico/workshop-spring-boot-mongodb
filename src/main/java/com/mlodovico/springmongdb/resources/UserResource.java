package com.mlodovico.springmongdb.resources;

import com.mlodovico.springmongdb.models.dtos.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import com.mlodovico.springmongdb.domains.User;
import com.mlodovico.springmongdb.services.UserService;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<UserDTO> findById(@PathVariable String id){
        try {
            User user = service.FindById(id);

            return ResponseEntity.ok().body(new UserDTO(user));
        } catch (RuntimeException e){
            return ResponseEntity.noContent().build();
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> insert(@RequestBody UserDTO userDTO){
        try {
            User newUser = service.fromDTO(userDTO);

            newUser = service.insert(newUser);

            URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newUser.getId()).toUri();
            return ResponseEntity.created(uri).build();
        } catch (RuntimeException e){
            return ResponseEntity.noContent().build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable String id){
        try {
            service.delete(id);

            return ResponseEntity.noContent().build();
        } catch (RuntimeException e){
            return ResponseEntity.noContent().build();
        }
    }
}