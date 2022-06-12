package com.godVoice.service.impl;

import com.godVoice.exceptions.EntityNotExistException;
import com.godVoice.service.ChapterService;
import com.godVoice.service.MessageService;
import com.godVoice.service.RandomService;
import com.godVoice.service.VolumeService;
import com.godVoice.service.ds.GodMessage;
import com.godVoice.service.ds.Range;
import com.godVoice.types.ChapterDTO;
import com.godVoice.types.VolumeDTO;
import org.springframework.beans.factory.annotation.Autowired;

public class MessageServiceImpl implements MessageService {

    @Autowired
    VolumeService volumeService;
    @Autowired
    ChapterService chapterService;
    @Autowired
    RandomService randomService;

    private final int MAX_VERSES_AMOUNT = 7;

    @Override
    public GodMessage prepareGodMessage() throws EntityNotExistException {
        VolumeDTO volume = defineVolumeShort();
        ChapterDTO chapter = defineChapterNumber(volume);
        Range verses = defineVerses(chapter);

        return prepareMessage(volume, chapter, verses);
    }

    @Override
    public String messageToString(GodMessage message) throws EntityNotExistException {
        message = prepareGodMessage();
        return String.format("%s, %d, %s", message.getVolumeShort(), message.getChapterNumber(), message.getVerses());
    }

    private VolumeDTO defineVolumeShort() throws EntityNotExistException {
        return volumeService.drawVolume();
    }

    private ChapterDTO defineChapterNumber(VolumeDTO volume) {
        return chapterService.drawChapterFromVolume(volume);
    }

    private Range defineVerses(ChapterDTO chapter) {
        return randomService.drawRange(chapter.getVerses(), MAX_VERSES_AMOUNT);
    }

    private GodMessage prepareMessage(VolumeDTO volume, ChapterDTO chapter, Range verses) {
        GodMessage message = new GodMessage();

        message.setVolumeShort(volume.getVolumeShort());
        message.setChapterNumber(chapter.getChapter());

        if (verses.getRangeFrom() == verses.getRangeTo()) {
            message.setVerses("" + verses.getRangeFrom());
        }
        else {
            message.setVerses(verses.getRangeFrom() + " - " + verses.getRangeTo());
        }

        return message;
    }

}
