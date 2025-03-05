package com.mlodovico.springmongdb.models.dtos;

import com.mlodovico.springmongdb.domains.User;

import java.io.Serializable;

public class AuthorDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String Id;
    private String name;

    public AuthorDTO(){
    }

    public AuthorDTO(User userObj){
        this.Id = userObj.getId();
        this.name = userObj.getName();
    }

}
