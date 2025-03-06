package com.mlodovico.springmongdb.config;

import com.mlodovico.springmongdb.domains.Post;
import com.mlodovico.springmongdb.domains.User;
import com.mlodovico.springmongdb.models.dtos.AuthorDTO;
import com.mlodovico.springmongdb.models.dtos.CommentDTO;
import com.mlodovico.springmongdb.repositories.PostRepository;
import com.mlodovico.springmongdb.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
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

        userRepository.saveAll(Arrays.asList(u1, u2, u3));

        Post p1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(u1));
        Post p2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(u1));
        Post p3 = new Post(null, sdf.parse("29/03/2018"), "Praiou", "Muito bom viajar para praia!", new AuthorDTO(u2));

        CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(u3));
        CommentDTO c2 = new CommentDTO("Aproveite", sdf.parse("22/03/2018"), new AuthorDTO(u2));
        CommentDTO c3 = new CommentDTO("Tenha um ótimo dia!", sdf.parse("23/03/2018"), new AuthorDTO(u3));

        p1.getComments().addAll(Arrays.asList(c1, c2, c3));

        postRepository.saveAll(Arrays.asList(p1, p2, p3));

        u1.getPosts().addAll(Arrays.asList(p1, p2));
        u2.getPosts().add(p3);

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
