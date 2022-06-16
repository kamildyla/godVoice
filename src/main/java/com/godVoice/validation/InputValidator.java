package com.godVoice.validation;

import com.godVoice.exceptions.InputException;

public class InputValidator {

    public static void idIsNotNull(Long id) throws InputException {
        if (id == null) {
            throw new InputException(null);
        }
    }

    public static void amountIsValid(int amount) throws InputException {
        if (amount <= 0) {
            throw new InputException(amount);
        }
    }
}
