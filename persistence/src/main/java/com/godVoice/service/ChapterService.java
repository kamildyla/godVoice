package com.godVoice.service;

import com.godVoice.exceptions.EntityNotExistException;
import com.godVoice.exceptions.InputException;
import com.godVoice.types.ChapterDTO;
import com.godVoice.types.VolumeDTO;

/**
 * Service for making operations on chapter.
 */
public interface ChapterService {

    /**
     * Finds chapter based on id.
     * @param id chapter id.
     * @return Single chapter transfer object.
     * @throws EntityNotExistException when entity with requested id does not exist in database.
     * @throws InputException when id is null.
     */
    ChapterDTO findById(Long id) throws EntityNotExistException, InputException;

    /**
     * Draws random chapter from given volume.
     * @param volume volume from which chapter will be drawn.
     * @return drawned chapter.
     * @throws EntityNotExistException when drawned chapter does not exist in database.
     * @throws InputException when chapter id is null.
     */
    ChapterDTO drawChapterFromVolume(VolumeDTO volume) throws EntityNotExistException, InputException;

}
