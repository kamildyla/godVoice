package com.godVoice.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "VOLUME")
public class VolumeEntity extends AbstractEntity{

    @Column(nullable = false)
    private String volumeName;

    @Column(nullable = false)
    private String volumeShort;

    @Column(nullable = false)
    private Integer chapterAmount;

    @OneToMany(mappedBy = "volume_id")
    private Collection<ChapterEntity> chapters = new ArrayList<>();

    public VolumeEntity() {}

    public VolumeEntity(String volumeName, String volumeShort, Integer chapterAmount, Collection<ChapterEntity> chapters) {
        this.volumeName = volumeName;
        this.volumeShort = volumeShort;
        this.chapterAmount = chapterAmount;
    }

    public String getVolumeName() {
        return volumeName;
    }

    public void setVolumeName(String volume) {
        this.volumeName = volume;
    }

    public String getVolumeShort() {
        return volumeShort;
    }

    public void setVolumeShort(String tomeShort) {
        this.volumeShort = tomeShort;
    }

    public Integer getChapterAmount() {
        return chapterAmount;
    }

    public void setChapterAmount(Integer chapters) {
        this.chapterAmount = chapters;
    }
}
