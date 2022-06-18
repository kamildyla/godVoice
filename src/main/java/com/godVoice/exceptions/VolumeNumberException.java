package com.godVoice.exceptions;

/**
 * Throw when the given volume number is less than 1 or more than 73.
 */
public class VolumeNumberException extends BusinessException {

    /**
     * Throw when the given volume number is less than 1 or more than 73.
     * @param number volume number which is out of bound.
     */
    public VolumeNumberException(Integer number){
        super("Wrong volume number: " + number);
    }
}
