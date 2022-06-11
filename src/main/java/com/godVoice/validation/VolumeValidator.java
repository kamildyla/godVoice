package com.godVoice.validation;

import com.godVoice.domain.VolumeEntity;
import com.godVoice.exceptions.EntityNotExistException;

import java.util.Optional;

public class VolumeValidator {

    public static void isPresent(Optional<VolumeEntity> entity) throws EntityNotExistException {
        if (entity.isEmpty()) {
            throw new EntityNotExistException();
        }
    }
}
