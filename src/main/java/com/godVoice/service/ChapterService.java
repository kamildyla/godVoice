package com.godVoice.service;

import com.godVoice.exceptions.EntityNotExistException;
import com.godVoice.types.ChapterDTO;

public interface ChapterService {

    ChapterDTO findById(Long id) throws EntityNotExistException;

}
