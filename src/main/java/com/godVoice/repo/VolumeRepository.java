package com.godVoice.repo;

import com.godVoice.domain.VolumeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface VolumeRepository extends JpaRepository<VolumeEntity, Long> {

    @Query("SELECT v.id FROM VolumeEntity v WHERE v.volumeNumber = :volumeNumber")
    Long findIdByVolumeNumber(
            @Param("volumeNumber") Integer volumeNumber);

    @Query("SELECT v.chapterAmount FROM VolumeEntity v WHERE v.id = :id")
    Integer findChapterAmountById(
            @Param("id") Long id);

    @Query("SELECT v.chapterAmount FROM VolumeEntity v WHERE v.volumeNumber = :volumeNumber")
    Integer findChapterAmountByVolumeNumber(
            @Param("volumeNumber") Integer volumeNumber);
}
