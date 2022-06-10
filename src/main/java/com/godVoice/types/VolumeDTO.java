package com.godVoice.types;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VolumeDTO {

    private Long id;
    private Long version;
    @NonNull
    private String volumeName;
    @NonNull
    private String volumeShort;
    @NonNull
    private Integer chapterAmount;

}
