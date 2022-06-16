package com.godVoice.service.impl;

import com.godVoice.exceptions.BusinessException;
import com.godVoice.service.ChapterService;
import com.godVoice.service.MessageService;
import com.godVoice.service.RandomService;
import com.godVoice.service.VolumeService;
import com.godVoice.service.ds.GodMessage;
import com.godVoice.service.ds.Range;
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

    private final int VOLUMES_AMOUNT = 73;

    private final int MAX_VERSES_AMOUNT = 7;

    @Override
    public GodMessage prepareGodMessage() throws BusinessException {
        VolumeDTO volume = drawVolume();
        ChapterDTO chapter = drawChapter(volume);
        Range verses = drawVerses(chapter);

        return prepareMessage(volume, chapter, verses);
    }

    @Override
    public String messageToString(GodMessage message)  {
        return String.format("%s, %d, %s", message.getVolumeShort(), message.getChapterNumber(), message.getVerses());
    }

    private VolumeDTO drawVolume() throws BusinessException {
        return volumeService.drawVolume(VOLUMES_AMOUNT);
    }

    private ChapterDTO drawChapter(VolumeDTO volume) throws BusinessException {
        return chapterService.drawChapterFromVolume(volume);
    }

    private Range drawVerses(ChapterDTO chapter) {
        int maxVersesAmount = MAX_VERSES_AMOUNT;
        if (chapter.getVerses() < maxVersesAmount) {
            maxVersesAmount = chapter.getVerses();
        }
        return randomService.drawRange(chapter.getVerses(), maxVersesAmount);
    }

    private GodMessage prepareMessage(VolumeDTO volume, ChapterDTO chapter, Range verses) {
        GodMessage message = new GodMessage();

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
