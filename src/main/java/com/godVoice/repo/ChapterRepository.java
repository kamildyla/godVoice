package com.godVoice.repo;

import com.godVoice.domain.ChapterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChapterRepository extends JpaRepository<ChapterEntity, Long> {

    @Query("SELECT c.id FROM ChapterEntity c " +
            "JOIN c.volumeNo v " +
            "WHERE v.volumeNumber = :volumeNumber " +
            "AND c.chapter = :chapterNumber")
    Long findIdByChapterAndVolumeNumber(
            @Param("chapterNumber") Integer chapterNumber,
            @Param("volumeNumber") Integer volumeNumber);
}
