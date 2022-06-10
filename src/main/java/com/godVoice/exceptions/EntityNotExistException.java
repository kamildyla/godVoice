package com.godVoice.exceptions;

public class EntityNotExistException extends Exception{

    public EntityNotExistException(Long id){
        super("Element with id: " + id + " does not exist");
    }

}
