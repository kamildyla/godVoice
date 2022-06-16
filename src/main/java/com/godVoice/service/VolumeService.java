package com.godVoice.service;

import com.godVoice.exceptions.EntityNotExistException;
import com.godVoice.exceptions.InputException;
import com.godVoice.exceptions.VolumeNumberException;
import com.godVoice.types.VolumeDTO;

public interface VolumeService {

    VolumeDTO findById(Long id) throws EntityNotExistException, InputException;

    VolumeDTO findByVolumeNumber(Integer volumeNumber) throws EntityNotExistException, VolumeNumberException, InputException;

    VolumeDTO drawVolume(int volumesAmount) throws EntityNotExistException, VolumeNumberException, InputException;

}
