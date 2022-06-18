package com.godVoice.service;

import com.godVoice.exceptions.EntityNotExistException;
import com.godVoice.exceptions.InputException;
import com.godVoice.exceptions.VolumeNumberException;
import com.godVoice.types.VolumeDTO;

/**
 * Service for making operations on volume.
 */
public interface VolumeService {

    /**
     * Finds volume based on id.
     * @param id volume id.
     * @return Single volume transfer object.
     * @throws EntityNotExistException when entity with requested id does not exist in database.
     * @throws InputException when id is null.
     */
    VolumeDTO findById(Long id) throws EntityNotExistException, InputException;

    /**
     * Finds volume based on volume number (from 1 to 73).
     * @param volumeNumber volume number.
     * @return Single volume transfer object.
     * @throws EntityNotExistException when entity with requested id does not exist in database.
     * @throws VolumeNumberException when given volume number is out of range (less than 1 or greather than 73)
     * @throws InputException when id is null.
     */
    VolumeDTO findByVolumeNumber(Integer volumeNumber) throws EntityNotExistException, VolumeNumberException, InputException;

    /**
     * Draws one volume.
     * @param volumesAmount volumes amount = 73.
     * @return Single volume transfer object.
     * @throws EntityNotExistException when entity with requested id does not exist in database.
     * @throws VolumeNumberException when given volume number is out of range (less than 1 or greather than 73)
     * @throws InputException when id is null.
     */
    VolumeDTO drawVolume(int volumesAmount) throws EntityNotExistException, VolumeNumberException, InputException;

}
