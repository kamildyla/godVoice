package com.godVoice.validation;

import com.godVoice.domain.VolumeEntity;
import com.godVoice.exceptions.EntityNotExistException;

import java.util.Optional;

public class VolumeValidator {

    public static void isPresent(Optional<VolumeEntity> entity, Long id) throws EntityNotExistException {
        if (entity.isEmpty()) {
            throw new EntityNotExistException(id);
        }
    }
}
