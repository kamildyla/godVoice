package com.godVoice.service;

import com.godVoice.exceptions.EntityNotExistException;
import com.godVoice.types.ChapterDTO;
import com.godVoice.types.VolumeDTO;

public interface ChapterService {

    ChapterDTO findById(Long id) throws EntityNotExistException;

//    ChapterDTO findIdByChapterAndVolumeNumber(int chapterNumber, int volumeNumber) throws EntityNotExistException;

    ChapterDTO drawChapterFromVolume(VolumeDTO volume) throws EntityNotExistException;
}
