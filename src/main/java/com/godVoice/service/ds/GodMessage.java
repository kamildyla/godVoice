package com.godVoice.service.ds;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GodMessage {

    private String volumeShort;
    private Integer chapterNumber;
    private Integer verseFrom;
    private Integer verseTo;

}
