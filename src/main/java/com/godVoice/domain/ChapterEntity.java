package com.godVoice.domain;

import javax.persistence.*;

@Entity
@Table(name = "CHAPTER")
public class ChapterEntity extends AbstractEntity{

    @Column(nullable = false)
    private Integer chapter;

    @Column(nullable = false)
    private Integer verses;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VOLUME_ID", nullable = false)
    private VolumeEntity volume;

    public ChapterEntity() {}

    public ChapterEntity(Integer chapter, Integer verses, VolumeEntity volume) {
        this.chapter = chapter;
        this.verses = verses;
        this.volume = volume;
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

    public VolumeEntity getVolume() {
        return volume;
    }

    public void setVolume(VolumeEntity volume) {
        this.volume = volume;
    }
}
