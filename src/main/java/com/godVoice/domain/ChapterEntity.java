package com.godVoice.domain;

import javax.persistence.*;

/**
 * Chapter contained in volume of Holy Bible.
 */
@Entity
@Table(name = "CHAPTER")
public class ChapterEntity extends AbstractEntity{

    /**
     * Ordinal number of volume (from 1 to 73).
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "VOLUME_NO", nullable = false)
    private VolumeEntity volumeNo;

    /**
     * Ordinal number of chapter (starts from 1 for each volume).
     */
    @Column(nullable = false)
    private Integer chapter;

    /**
     * Amount of verses contained in chapter (starts from 1 for each chapter).
     */
    @Column(nullable = false)
    private Integer verses;

    public ChapterEntity() {}

    public ChapterEntity(Integer chapter, Integer verses, VolumeEntity volumeNo) {
        this.chapter = chapter;
        this.verses = verses;
        this.volumeNo = volumeNo;
    }

    public Integer getChapter() {
        return chapter;
    }

    public void setChapter(Integer chapter) {
        this.chapter = chapter;
    }

    public Integer getVerses() {
        return verses;
    }

    public void setVerses(Integer verses) {
        this.verses = verses;
    }

    public VolumeEntity getVolumeNo() {
        return volumeNo;
    }

    public void setVolumeNo(VolumeEntity volume) {
        this.volumeNo = volume;
    }
}
