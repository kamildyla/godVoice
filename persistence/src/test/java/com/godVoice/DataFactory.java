package com.godVoice;

import com.godVoice.entity.ChapterEntity;
import com.godVoice.entity.VolumeEntity;
import com.godVoice.repo.ChapterRepository;
import com.godVoice.repo.VolumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataFactory {

    @Autowired
    private VolumeRepository volumeRepo;
    @Autowired
    private ChapterRepository chapterRepo;

    private ChapterEntity chapter;

    public void loadVolumesAndChapters() {
        VolumeEntity volume1 = new VolumeEntity(1, "Volume One", "V1", 11);
        volumeRepo.save(volume1);
        VolumeEntity volume2 = new VolumeEntity(2, "Volume Two", "V2", 12);
        volumeRepo.save(volume2);
        VolumeEntity volume3 = new VolumeEntity(3, "Volume Three", "V3", 13);
        volumeRepo.save(volume3);
        VolumeEntity volume4 = new VolumeEntity(4, "Volume Four", "V4", 14);
        volumeRepo.save(volume4);
        VolumeEntity volume5 = new VolumeEntity(5, "Volume Five", "V5", 15);
        volumeRepo.save(volume5);

        createChapters(11, 20, volume1);
        createChapters(12, 30, volume2);
        createChapters(13, 10, volume3);
        createChapters(14, 50, volume4);
        createChapters(15, 40, volume5);
    }

    private void createChapters(int entityAmount, int verseStartNumber, VolumeEntity volume) {
        for (int i = 1; i <= entityAmount; i++) {
            chapter = new ChapterEntity(i, verseStartNumber + i - 1, volume);
            chapterRepo.save(chapter);
        }
    }

    public void deleteVolumesAndChapters() {
        chapterRepo.deleteAll();
        volumeRepo.deleteAll();
    }

}
