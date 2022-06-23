package com.godVoice.repo;

import com.godVoice.entity.ChapterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Repository for making searches through chapter entity.
 */
public interface ChapterRepository extends JpaRepository<ChapterEntity, Long> {

    /**
     * Finds id of chapter based on chapter ordinal number and volume ordinal number.
     * @param chapterNumber chapter ordinal number.
     * @param volumeNumber volume ordinal number.
     * @return id of chapter.
     */
    @Query("SELECT c.id FROM ChapterEntity c " +
            "JOIN c.volumeNo v " +
            "WHERE v.volumeNumber = :volumeNumber " +
            "AND c.chapter = :chapterNumber")
    Long findIdByChapterAndVolumeNumber(
            @Param("chapterNumber") Integer chapterNumber,
            @Param("volumeNumber") Integer volumeNumber);

}
