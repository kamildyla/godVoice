package com.godVoice.service.impl;

import com.godVoice.constants.HolyBibleConst;
import com.godVoice.domain.VolumeEntity;
import com.godVoice.exceptions.EntityNotExistException;
import com.godVoice.exceptions.InputException;
import com.godVoice.exceptions.VolumeNumberException;
import com.godVoice.mappers.VolumeMapper;
import com.godVoice.repo.VolumeRepository;
import com.godVoice.service.RandomService;
import com.godVoice.service.VolumeService;
import com.godVoice.types.VolumeDTO;
import com.godVoice.validation.InputValidator;
import com.godVoice.validation.VolumeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VolumeServiceImpl implements VolumeService {

    @Autowired
    private VolumeRepository volumeRepo;

    @Autowired
    private RandomService randomService;

    @Override
    public VolumeDTO findById(Long id) throws EntityNotExistException, InputException {
        InputValidator.idIsNotNull(id);
        Optional<VolumeEntity> volumeEntityOpt = volumeRepo.findById(id);
        VolumeValidator.isPresent(volumeEntityOpt);
        return VolumeMapper.toVolumeDTO(volumeEntityOpt.get());
    }

    @Override
    public VolumeDTO findByVolumeNumber(Integer volumeNumber) throws VolumeNumberException, EntityNotExistException, InputException {
        VolumeValidator.checkVolumeNumber(volumeNumber, HolyBibleConst.VOLUMES_AMOUNT);
        Long volume_id = volumeRepo.findIdByVolumeNumber(volumeNumber);
        return this.findById(volume_id);
    }

    @Override
    public VolumeDTO drawVolume(int volumesAmount) throws InputException, VolumeNumberException, EntityNotExistException {
        InputValidator.amountIsValid(volumesAmount);
        Integer volumeNo = randomService.drawOneNumber(volumesAmount);
        return this.findByVolumeNumber(volumeNo);
    }


}
