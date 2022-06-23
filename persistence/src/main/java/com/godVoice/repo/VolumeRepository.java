package com.godVoice.repo;

import com.godVoice.entity.VolumeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Repository for making searches through volume entity.
 */
public interface VolumeRepository extends JpaRepository<VolumeEntity, Long> {

    /**
     * Finds id of volume based on volume ordinal number.
     * @param volumeNumber volume ordinal number.
     * @return id of volume.
     */
    @Query("SELECT v.id FROM VolumeEntity v WHERE v.volumeNumber = :volumeNumber")
    Long findIdByVolumeNumber(
            @Param("volumeNumber") Integer volumeNumber);

}
