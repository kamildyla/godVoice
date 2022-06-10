package com.godVoice.service;

import com.godVoice.exceptions.EntityNotExistException;
import com.godVoice.types.VolumeDTO;

public interface VolumeService {

    VolumeDTO findById(Long id) throws EntityNotExistException;

    Integer findChapterAmountById(Long id);
}
