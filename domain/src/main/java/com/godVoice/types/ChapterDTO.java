package com.godVoice.types;

import com.godVoice.entity.VolumeEntity;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ChapterDTO {

    private Long id;
    private Long version;
    @NonNull
    private VolumeEntity volumeNo;
    @NonNull
    private Integer chapter;
    @NonNull
    private Integer verses;
}
