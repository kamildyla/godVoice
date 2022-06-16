package com.godVoice.mappers;

import com.godVoice.domain.VolumeEntity;
import com.godVoice.types.VolumeDTO;

import java.util.List;
import java.util.stream.Collectors;

public class VolumeMapper {

    public static VolumeDTO toVolumeDTO(VolumeEntity volumeEntity) {
        if (volumeEntity == null) {
            return null;
        }

        return VolumeDTO.builder()
                .id(volumeEntity.getId())
                .version(volumeEntity.getVersion())
                .volumeNumber(volumeEntity.getVolumeNumber())
                .volumeName(volumeEntity.getVolumeName())
                .volumeShort(volumeEntity.getVolumeShort())
                .chapterAmount(volumeEntity.getChapterAmount())
                .build();
    }

    public static VolumeEntity toVolumeEntity(VolumeDTO volumeDTO) {
        if (volumeDTO == null) {
            return null;
        }

        VolumeEntity volumeEntity = new VolumeEntity();
        volumeEntity.setId(volumeDTO.getId());
        volumeEntity.setVersion(volumeDTO.getVersion());
        volumeEntity.setVolumeNumber(volumeDTO.getVolumeNumber());
        volumeEntity.setVolumeName(volumeDTO.getVolumeName());
        volumeEntity.setVolumeShort(volumeDTO.getVolumeShort());
        volumeEntity.setChapterAmount(volumeDTO.getChapterAmount());

        return volumeEntity;
    }

    public static List<VolumeDTO> mapToDTOs(List<VolumeEntity> volumeEntities) {
        return volumeEntities.stream()
                .map(VolumeMapper::toVolumeDTO)
                .collect(Collectors.toList());
    }

    public static List<VolumeEntity> mapToEntities(List<VolumeDTO> volumeDTOs) {
        return volumeDTOs.stream()
                .map(VolumeMapper::toVolumeEntity)
                .collect(Collectors.toList());
    }
}
