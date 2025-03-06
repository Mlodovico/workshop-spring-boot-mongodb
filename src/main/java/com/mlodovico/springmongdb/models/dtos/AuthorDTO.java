package com.mlodovico.springmongdb.models.dtos;

import com.mlodovico.springmongdb.domains.User;

import java.io.Serial;
import java.io.Serializable;

public class AuthorDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String Id;
    private String name;

    public AuthorDTO(){
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AuthorDTO(User userObj){
        this.Id = userObj.getId();
        this.name = userObj.getName();
    }

}
