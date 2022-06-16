package com.godVoice.service;

import com.godVoice.exceptions.EntityNotExistException;
import com.godVoice.exceptions.InputException;
import com.godVoice.types.ChapterDTO;
import com.godVoice.types.VolumeDTO;

public interface ChapterService {

    ChapterDTO findById(Long id) throws EntityNotExistException, InputException;

    ChapterDTO drawChapterFromVolume(VolumeDTO volume) throws EntityNotExistException, InputException;
}
