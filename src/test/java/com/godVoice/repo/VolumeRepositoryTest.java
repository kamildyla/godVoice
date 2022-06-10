package com.godVoice.repo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class VolumeRepositoryTest {

    @Autowired
    VolumeRepository volumeRepository;

    @Test
    public void shouldReturnRightChapterAmount(){
        // TODO zrobić imitację DB do testów jednostkowych; Zrobić drugą DB z application.properties dla testów integracyjnych
        // given
        Integer expected = 50;
        // when
        Integer result = volumeRepository.findChapterAmountById(1L);
        // then
        assertEquals(expected, result);
    }
}