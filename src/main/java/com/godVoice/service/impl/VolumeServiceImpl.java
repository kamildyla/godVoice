package com.godVoice.service.impl;

import com.godVoice.domain.VolumeEntity;
import com.godVoice.exceptions.EntityNotExistException;
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

    @Override
    public VolumeDTO findById(Long id) throws EntityNotExistException {
        Optional<VolumeEntity> volumeEntityOpt = volumeRepo.findById(id);
        VolumeValidator.isPresent(volumeEntityOpt);
        return VolumeMapper.toVolumeDTO(volumeEntityOpt.get());
    }

    @Override
    public VolumeDTO findByVolumeNumber(Integer volumeNumber) throws EntityNotExistException {
        Long volume_id = volumeRepo.findIdByVolumeNumber(volumeNumber);
        return this.findById(volume_id);
    }

    @Override
    public Integer findChapterAmountById(Long id) {
        return volumeRepo.findChapterAmountById(id);
    }

    @Override
    public Integer findChapterAmountByVolumeNumber(Integer volumeNumber) {
        return volumeRepo.findChapterAmountByVolumeNumber(volumeNumber);
    }

    @Override
    public VolumeDTO drawVolume(int volumesAmount) throws EntityNotExistException {
        Integer volumeNo = randomService.drawOneNumber(volumesAmount);
        return this.findByVolumeNumber(volumeNo);
    }


}
