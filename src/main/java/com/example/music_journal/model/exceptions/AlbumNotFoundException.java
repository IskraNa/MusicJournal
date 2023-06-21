package com.example.music_journal.model.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class AlbumNotFoundException extends RuntimeException{

    public AlbumNotFoundException(Long id){
        super(String.format(("Album with id %d not found!"),id));
    }
}
