package com.godVoice.service.impl;

import com.godVoice.domain.VolumeEntity;
import com.godVoice.exceptions.EntityNotExistException;
import com.godVoice.mappers.VolumeMapper;
import com.godVoice.repo.VolumeRepository;
import com.godVoice.service.VolumeService;
import com.godVoice.types.VolumeDTO;
import com.godVoice.validation.VolumeValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VolumeServiceImpl implements VolumeService {

    @Autowired
    VolumeRepository volumeRepo;

    @Override
    public VolumeDTO findById(Long id) throws EntityNotExistException {
        Optional<VolumeEntity> volumeEntityOpt = volumeRepo.findById(id);
        VolumeValidator.isPresent(volumeEntityOpt, id);
        return VolumeMapper.toVolumeDTO(volumeEntityOpt.get());
    }

    @Override
    public Integer findChapterAmountById(Long id) {
        volumeRepo.findChapterAmountById(id);
        return null;
    }


}
