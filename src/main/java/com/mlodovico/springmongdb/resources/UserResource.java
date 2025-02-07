package com.mlodovico.springmongdb.resources;

import ch.qos.logback.core.joran.spi.HttpUtil;
import com.mlodovico.springmongdb.domain.User;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @RequestMapping(method = HttpUtil.RequestMethod.GET)
    public ResponseEntity<List<User>> findAll(){
        User maria = new User("1", "Maria Brown", "maria@gmail.com");
        User alex = new User("2", "Alex Silva", "alex@gmail.com");

        List<User> list = new ArrayList<>(Arrays.asList(maria, alex));

        return ResponseEntity.ok().body(list);
    }
}
