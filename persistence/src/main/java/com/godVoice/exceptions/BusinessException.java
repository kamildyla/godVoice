package com.godVoice.exceptions;

/**
 * Throw when an error occurred related to GodVoice application.
 */
public class BusinessException extends Exception{

    public BusinessException(String message){
        super(message);
    }

}
