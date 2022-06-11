package com.godVoice.service;

import com.godVoice.exceptions.EntityNotExistException;
import com.godVoice.types.VolumeDTO;

public interface VolumeService {

    VolumeDTO findById(Long id) throws EntityNotExistException;

    VolumeDTO findByVolumeNumber(Integer volumeNumber) throws EntityNotExistException;

    Integer findChapterAmountById(Long id);

    Integer findChapterAmountByVolumeNumber(Integer volumeNumber);

    VolumeDTO drawVolume() throws EntityNotExistException;

}
