package com.godVoice.service.impl;

import com.godVoice.domain.VolumeEntity;
import com.godVoice.exceptions.BusinessException;
import com.godVoice.mappers.VolumeMapper;
import com.godVoice.service.ChapterService;
import com.godVoice.service.MessageService;
import com.godVoice.service.RandomService;
import com.godVoice.service.VolumeService;
import com.godVoice.service.ds.Range;
import com.godVoice.types.ChapterDTO;
import com.godVoice.types.VolumeDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class MessageServiceTest {

    @Autowired
    private MessageService messageService;
    @MockBean
    private VolumeService volumeService;
    @MockBean
    private ChapterService chapterService;
    @MockBean
    private RandomService randomService;

    @Test
    public void shouldCreateMessage() throws BusinessException {
        // given
        VolumeDTO volumeDTO = VolumeDTO.builder()
                .id(1L)
                .volumeName("VolumeName")
                .volumeShort("vol1")
                .volumeNumber(5)
                .chapterAmount(2)
                .build();
        VolumeEntity volumeEntity = VolumeMapper.toVolumeEntity(volumeDTO);
        ChapterDTO chapterDTO = ChapterDTO.builder()
                .id(2L)
                .volumeNo(volumeEntity)
                .chapter(2)
                .verses(30)
                .build();
        Range verses = Range.builder()
                .rangeFrom(12)
                .rangeTo(16)
                .build();

        when(volumeService.drawVolume(anyInt())).thenReturn(volumeDTO);
        when(chapterService.drawChapterFromVolume(any())).thenReturn(chapterDTO);
        when(randomService.drawRange(anyInt(), anyInt())).thenReturn(verses);

        // when
        String result = messageService.messageToString(messageService.prepareGodMessage());

        // then
        assertEquals("vol1, 2, 12-16", result);
    }

}