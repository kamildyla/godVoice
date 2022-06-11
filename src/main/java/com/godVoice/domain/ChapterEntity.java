package com.godVoice.domain;

import javax.persistence.*;

@Entity
@Table(name = "CHAPTER")
public class ChapterEntity extends AbstractEntity{

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "VOLUME_NO", nullable = false)
    private VolumeEntity volumeNo;

    @Column(nullable = false)
    private Integer chapter;

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
