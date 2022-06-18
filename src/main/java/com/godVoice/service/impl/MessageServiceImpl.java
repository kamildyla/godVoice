package com.godVoice.service.impl;

import com.godVoice.constants.HolyBibleConst;
import com.godVoice.exceptions.BusinessException;
import com.godVoice.service.ChapterService;
import com.godVoice.service.MessageService;
import com.godVoice.service.RandomService;
import com.godVoice.service.VolumeService;
import com.godVoice.service.ds.GodMessageDs;
import com.godVoice.service.ds.RangeDs;
import com.godVoice.types.ChapterDTO;
import com.godVoice.types.VolumeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    VolumeService volumeService;
    @Autowired
    ChapterService chapterService;
    @Autowired
    RandomService randomService;

    @Override
    public GodMessageDs prepareGodMessage() throws BusinessException {
        VolumeDTO volume = drawVolume();
        ChapterDTO chapter = drawChapter(volume);
        RangeDs verses = drawVerses(chapter);

        return prepareMessage(volume, chapter, verses);
    }

    private VolumeDTO drawVolume() throws BusinessException {
        return volumeService.drawVolume(HolyBibleConst.VOLUMES_AMOUNT);
    }

    private ChapterDTO drawChapter(VolumeDTO volume) throws BusinessException {
        return chapterService.drawChapterFromVolume(volume);
    }

    private RangeDs drawVerses(ChapterDTO chapter) {
        int maxVersesAmount = HolyBibleConst.MAX_VERSES_AMOUNT;
        if (chapter.getVerses() < maxVersesAmount) {
            maxVersesAmount = chapter.getVerses();
        }
        return randomService.drawRange(chapter.getVerses(), maxVersesAmount);
    }

    private GodMessageDs prepareMessage(VolumeDTO volume, ChapterDTO chapter, RangeDs verses) {
        GodMessageDs message = new GodMessageDs();

        message.setVolumeShort(volume.getVolumeShort());
        message.setChapterNumber(chapter.getChapter());

        if (verses.getRangeFrom() == verses.getRangeTo()) {
            message.setVerses("" + verses.getRangeFrom());
        }
        else {
            message.setVerses(verses.getRangeFrom() + "-" + verses.getRangeTo());
        }

        return message;
    }

}
