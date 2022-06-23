package com.godVoice.exceptions;

/**
 * Throw when the input data does not meet the acceptance requirements.
 */
public class InputException extends BusinessException {

    /**
     * Throw when the input data does not meet the acceptance requirements.
     * @param element object which does not meet the acceptance requirements.
     */
    public InputException(Object element){
        super("Input element is wrong: " + element);
    }

}
