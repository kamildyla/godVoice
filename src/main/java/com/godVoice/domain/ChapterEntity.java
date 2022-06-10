package com.godVoice.domain;

import javax.persistence.*;

@Entity
@Table(name = "CHAPTER")
public class ChapterEntity extends AbstractEntity{

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "VOLUME_ID", nullable = false)
    private VolumeEntity volume_id;

    @Column(nullable = false)
    private Integer chapter;

    @Column(nullable = false)
    private Integer verses;

    public ChapterEntity() {}

    public ChapterEntity(Integer chapter, Integer verses, VolumeEntity volume_id) {
        this.chapter = chapter;
        this.verses = verses;
        this.volume_id = volume_id;
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

    public VolumeEntity getVolume_id() {
        return volume_id;
    }

    public void setVolume_id(VolumeEntity volume) {
        this.volume_id = volume;
    }
}
