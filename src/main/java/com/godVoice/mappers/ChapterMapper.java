package com.godVoice.mappers;

import com.godVoice.domain.ChapterEntity;
import com.godVoice.types.ChapterDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ChapterMapper {

    public static ChapterDTO toChapterDTO(ChapterEntity chapterEntity) {
        if (chapterEntity == null) {
            return null;
        }

        return ChapterDTO.builder()
                .id(chapterEntity.getId())
                .version(chapterEntity.getVersion())
                .volume_id(chapterEntity.getVolume_id())
                .chapter(chapterEntity.getChapter())
                .verses(chapterEntity.getVerses())
                .build();
    }

    public static ChapterEntity toChapterEntity(ChapterDTO chapterDTO) {
        if (chapterDTO == null) {
            return null;
        }

        ChapterEntity chapterEntity = new ChapterEntity();
        chapterEntity.setId(chapterDTO.getId());
        chapterEntity.setVersion(chapterDTO.getVersion());
        chapterEntity.setVolume_id(chapterDTO.getVolume_id());
        chapterEntity.setChapter(chapterDTO.getChapter());
        chapterEntity.setVerses(chapterEntity.getVerses());

        return chapterEntity;
    }

    public static List<ChapterDTO> mapToDTOs(List<ChapterEntity> chapterEntities) {
        return chapterEntities.stream()
                .map(ChapterMapper::toChapterDTO)
                .collect(Collectors.toList());
    }

    public static List<ChapterEntity> mapToEntities(List<ChapterDTO> chapterDTOs) {
        return chapterDTOs.stream()
                .map(ChapterMapper::toChapterEntity)
                .collect(Collectors.toList());
    }

}
