package com.mlodovico.springmongdb.config;

import com.mlodovico.springmongdb.domains.Post;
import com.mlodovico.springmongdb.domains.User;
import com.mlodovico.springmongdb.repositories.PostRepository;
import com.mlodovico.springmongdb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        User u1 = new User(null, "Maria Brown", "mariab@gmail.com");
        User u2 = new User(null, "Alex Green", "alexgr@yahoo.com");
        User u3 = new User(null, "Bob Grey", "bob@yahoo.com");

        Post p1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", u1);
        Post p2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", u1);
        Post p3 = new Post(null, sdf.parse("29/03/2018"), "Praiou", "Muito bom viajar para praia!", u2);

        userRepository.saveAll(Arrays.asList(u1, u2, u3));
        postRepository.saveAll(Arrays.asList(p1, p2, p3));
    }
}
