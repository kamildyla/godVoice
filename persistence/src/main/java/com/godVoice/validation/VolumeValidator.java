package com.godVoice.validation;

import com.godVoice.entity.VolumeEntity;
import com.godVoice.exceptions.EntityNotExistException;
import com.godVoice.exceptions.InputException;
import com.godVoice.exceptions.VolumeNumberException;
import com.godVoice.types.VolumeDTO;

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

    public static void volumeIsNotNull(VolumeDTO volume) throws InputException {
        if (volume == null) {
            throw new InputException(null);
        }
    }

}
