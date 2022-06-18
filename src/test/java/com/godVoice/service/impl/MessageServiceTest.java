package com.godVoice.service.impl;

import com.godVoice.domain.VolumeEntity;
import com.godVoice.exceptions.BusinessException;
import com.godVoice.mappers.VolumeMapper;
import com.godVoice.service.ChapterService;
import com.godVoice.service.MessageService;
import com.godVoice.service.VolumeService;
import com.godVoice.service.ds.GodMessageDs;
import com.godVoice.service.ds.RangeDs;
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
    private RandomServiceImpl randomServiceImpl;

    @Test
    public void shouldCreateMessage() throws BusinessException {
        // given
        VolumeDTO volumeDTO = VolumeDTO.builder()
                .id(1L)
                .volumeName("VolumeName")
                .volumeShort("vol5")
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
        RangeDs verses = RangeDs.builder()
                .rangeFrom(12)
                .rangeTo(16)
                .build();

        when(volumeService.drawVolume(anyInt())).thenReturn(volumeDTO);
        when(chapterService.drawChapterFromVolume(any())).thenReturn(chapterDTO);
        when(randomServiceImpl.drawRange(anyInt(), anyInt())).thenReturn(verses);

        // when
        GodMessageDs message = messageService.prepareGodMessage();

        // then
        assertEquals("vol5", message.getVolumeShort());
        assertEquals(2, message.getChapterNumber());
        assertEquals("12-16", message.getVerses());
    }

    @Test
    public void shouldCreateProperMessageWhenVersesAmountIsLessThanMaxRange() throws BusinessException {
        // given
        VolumeDTO volumeDTO = VolumeDTO.builder()
                .id(2L)
                .volumeName("VolumeTwo")
                .volumeShort("vol2")
                .volumeNumber(2)
                .chapterAmount(1)
                .build();
        VolumeEntity volumeEntity = VolumeMapper.toVolumeEntity(volumeDTO);
        ChapterDTO chapterDTO = ChapterDTO.builder()
                .id(1L)
                .volumeNo(volumeEntity)
                .chapter(1)
                .verses(1)
                .build();

        when(volumeService.drawVolume(anyInt())).thenReturn(volumeDTO);
        when(chapterService.drawChapterFromVolume(any())).thenReturn(chapterDTO);
        when(randomServiceImpl.drawRange(anyInt(), anyInt())).thenCallRealMethod();
        when(randomServiceImpl.drawOneNumber(anyInt())).thenCallRealMethod();

        // when
        GodMessageDs message = messageService.prepareGodMessage();

        // then
        assertEquals("vol2", message.getVolumeShort());
        assertEquals(1, message.getChapterNumber());
        assertEquals("1", message.getVerses());
    }

}