package com.godVoice.types;

import com.godVoice.domain.VolumeEntity;
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
    private VolumeEntity volume_id;
    @NonNull
    private Integer chapter;
    @NonNull
    private Integer verses;
}
