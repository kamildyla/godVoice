package com.godVoice.exceptions;

public class EntityNotExistException extends BusinessException {

    public EntityNotExistException(){
        super("Element does not exist");
    }

}
