package com.godVoice.validation;

import com.godVoice.entity.ChapterEntity;
import com.godVoice.exceptions.EntityNotExistException;

import java.util.Optional;

public class ChapterValidator {

    public static void isPresent(Optional<ChapterEntity> entity) throws EntityNotExistException {
        if (entity.isEmpty()) {
            throw new EntityNotExistException();
        }
    }

}
