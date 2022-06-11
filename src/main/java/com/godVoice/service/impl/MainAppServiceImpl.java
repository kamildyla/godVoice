package com.godVoice.service.impl;

import com.godVoice.exceptions.EntityNotExistException;
import com.godVoice.service.ChapterService;
import com.godVoice.service.MainAppService;
import com.godVoice.service.VolumeService;
import com.godVoice.service.ds.GodMessage;
import com.godVoice.types.ChapterDTO;
import com.godVoice.types.VolumeDTO;
import org.springframework.beans.factory.annotation.Autowired;

public class MainAppServiceImpl implements MainAppService {

    @Autowired
    VolumeService volumeService;
    @Autowired
    ChapterService chapterService;

    @Override
    public GodMessage prepareGodMessage() throws EntityNotExistException {
        GodMessage message = new GodMessage();

        VolumeDTO volume = defineVolumeShort(message);
        ChapterDTO chapter = defineChapterNumber(volume, message);

        return null;
    }

    private VolumeDTO defineVolumeShort(GodMessage message) throws EntityNotExistException {
        VolumeDTO volume = volumeService.drawVolume();
        message.setVolumeShort(volume.getVolumeShort());
        return volume;
    }

    private ChapterDTO defineChapterNumber(VolumeDTO volume, GodMessage message) {
        ChapterDTO chapter = chapterService.drawChapterFromVolume(volume);
        message.setChapterNumber(chapter.getChapter());
        return chapter;
    }
}
