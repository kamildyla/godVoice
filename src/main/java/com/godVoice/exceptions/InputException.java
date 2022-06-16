package com.godVoice.exceptions;

public class InputException extends BusinessException{

    public InputException(Object element){
        super("Input element is wrong: " + element);
    }

}
