package com.godVoice.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Volume of the Holy Bible.
 */
@Entity
@Table(name = "VOLUME")
public class VolumeEntity extends AbstractEntity {

    /**
     * Ordinal number of volume (from 1 to 73).
     */
    @Column(nullable = false)
    private Integer volumeNumber;

    /**
     * Full name of volume.
     */
    @Column(nullable = false)
    private String volumeName;

    /**
     * Shortened form of volume.
     */
    @Column(nullable = false)
    private String volumeShort;

    /**
     * Amount of chapters in volume.
     */
    @Column(nullable = false)
    private Integer chapterAmount;

    /**
     * Collection of chapters entity contained in volume.
     */
    @OneToMany(
            mappedBy = "volumeNo",
            cascade = CascadeType.REMOVE
    )
    private Collection<ChapterEntity> chapters = new ArrayList<>();

    public VolumeEntity() {}

    public VolumeEntity(Integer volumeNumber, String volumeName, String volumeShort, Integer chapterAmount) {
        this.volumeNumber = volumeNumber;
        this.volumeName = volumeName;
        this.volumeShort = volumeShort;
        this.chapterAmount = chapterAmount;
    }

    public Integer getVolumeNumber() {
        return volumeNumber;
    }

    public void setVolumeNumber(Integer volumeNumber) {
        this.volumeNumber = volumeNumber;
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
