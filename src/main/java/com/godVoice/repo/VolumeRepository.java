package com.godVoice.repo;

import com.godVoice.domain.VolumeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VolumeRepository extends JpaRepository<VolumeEntity, Long> {
}
