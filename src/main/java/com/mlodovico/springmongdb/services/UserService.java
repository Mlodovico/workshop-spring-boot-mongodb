package com.mlodovico.springmongdb.services;

import com.mlodovico.springmongdb.repositories.UserRepository;
import com.mlodovico.springmongdb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.mlodovico.springmongdb.domains.User;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        List<User> list = repo.findAll();

        if(list.isEmpty()){
            throw new RuntimeException("Status: 204, No users found");
        }

        return list;
    }

    public User FindById(String id) {
        User user = repo.findById(id).orElse(null);

        if (user == null) {
            throw new ObjectNotFoundException("Status: 404, User not found");
        }

        return user;
    }
}
