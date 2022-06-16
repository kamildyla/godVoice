package com.godVoice.service.impl;

import com.godVoice.domain.ChapterEntity;
import com.godVoice.exceptions.EntityNotExistException;
import com.godVoice.mappers.ChapterMapper;
import com.godVoice.repo.ChapterRepository;
import com.godVoice.service.ChapterService;
import com.godVoice.service.RandomService;
import com.godVoice.types.ChapterDTO;
import com.godVoice.types.VolumeDTO;
import com.godVoice.validation.ChapterValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    private ChapterRepository chapterRepo;
    @Autowired
    private RandomService randomService;

    @Override
    public ChapterDTO findById(Long id) throws EntityNotExistException {
        Optional<ChapterEntity> chapterEntityOpt = chapterRepo.findById(id);
        ChapterValidator.isPresent(chapterEntityOpt);
        return ChapterMapper.toChapterDTO(chapterEntityOpt.get());
    }

    @Override
    public ChapterDTO drawChapterFromVolume(VolumeDTO volume) throws EntityNotExistException {
        int chapterNumber = randomService.drawOneNumber(volume.getChapterAmount());
        Long chapterId = chapterRepo.findIdByChapterAndVolumeNumber(chapterNumber, volume.getVolumeNumber());
        return findById(chapterId);
    }
}
