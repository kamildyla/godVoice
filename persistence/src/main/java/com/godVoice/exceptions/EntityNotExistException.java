package com.godVoice.exceptions;

/**
 * Thrown when requested entity does not exist in database.
 */
public class EntityNotExistException extends BusinessException {

    public EntityNotExistException(){
        super("Element does not exist");
    }

}
