package com.godVoice.exceptions;

public class VolumeNumberException extends BusinessException {

    public VolumeNumberException(Integer number){
        super("Wrong volume number: " + number);
    }
}
