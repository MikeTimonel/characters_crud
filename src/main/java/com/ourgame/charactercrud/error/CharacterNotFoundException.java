package com.ourgame.charactercrud.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class CharacterNotFoundException extends RuntimeException{

    public CharacterNotFoundException(String id) {
        super("Character with ID " + id + " not found.");
    }
}
