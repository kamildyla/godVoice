package com.godVoice.service.impl;

import com.godVoice.domain.VolumeEntity;
import com.godVoice.exceptions.EntityNotExistException;
import com.godVoice.exceptions.VolumeNumberException;
import com.godVoice.mappers.VolumeMapper;
import com.godVoice.repo.VolumeRepository;
import com.godVoice.service.RandomService;
import com.godVoice.service.VolumeService;
import com.godVoice.types.VolumeDTO;
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

    private final int MAX_VOLUME_NUMBER = 73;

    @Override
    public VolumeDTO findById(Long id) throws EntityNotExistException {
        Optional<VolumeEntity> volumeEntityOpt = volumeRepo.findById(id);
        VolumeValidator.isPresent(volumeEntityOpt);
        return VolumeMapper.toVolumeDTO(volumeEntityOpt.get());
    }

    @Override
    public VolumeDTO findByVolumeNumber(Integer volumeNumber) throws VolumeNumberException, EntityNotExistException {
        VolumeValidator.checkVolumeNumber(volumeNumber, MAX_VOLUME_NUMBER);
        Long volume_id = volumeRepo.findIdByVolumeNumber(volumeNumber);
        return this.findById(volume_id);
    }

    @Override
    public VolumeDTO drawVolume(int volumesAmount) throws VolumeNumberException, EntityNotExistException {
        Integer volumeNo = randomService.drawOneNumber(volumesAmount);
        return this.findByVolumeNumber(volumeNo);
    }


}
