package com.godVoice.validation;

import com.godVoice.domain.VolumeEntity;
import com.godVoice.exceptions.EntityNotExistException;
import com.godVoice.exceptions.VolumeNumberException;

import java.util.Optional;

public class VolumeValidator {

    public static void isPresent(Optional<VolumeEntity> entity) throws EntityNotExistException {
        if (entity.isEmpty()) {
            throw new EntityNotExistException();
        }
    }

    public static void checkVolumeNumber(Integer volumeNumber, int maxVolumeNumber) throws VolumeNumberException {
        if (volumeNumber == null || volumeNumber < 1 || volumeNumber > maxVolumeNumber) {
            throw new VolumeNumberException(volumeNumber);
        }
    }
}
