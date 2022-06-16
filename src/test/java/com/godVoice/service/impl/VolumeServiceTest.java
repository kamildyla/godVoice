package com.godVoice.service.impl;

import com.godVoice.DataFactory;
import com.godVoice.exceptions.BusinessException;
import com.godVoice.exceptions.EntityNotExistException;
import com.godVoice.exceptions.InputException;
import com.godVoice.exceptions.VolumeNumberException;
import com.godVoice.repo.VolumeRepository;
import com.godVoice.service.VolumeService;
import com.godVoice.types.VolumeDTO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class VolumeServiceTest {

    @Autowired
    private DataFactory dataFactory;
    @Autowired
    private VolumeService volumeService;
    @Autowired
    private VolumeRepository volumeRepo;

    private final int VOLUMES_AMOUNT = 5;

    @BeforeAll
    public void setUp() {
        dataFactory.loadVolumesAndChapters();
    }

    @AfterAll
    public void cleanUp() {
        dataFactory.deleteVolumesAndChapters();
    }

    @RepeatedTest(20)
    public void shouldReturnRandomVolume() throws BusinessException {
        // given when
        VolumeDTO volume = volumeService.drawVolume(VOLUMES_AMOUNT);
        int result = volume.getVolumeNumber();
        // then
        assertTrue(result >= 1 && result <= 5);
    }

    @Test
    public void shouldThrowExceptionWhenAmountIsLessOrEqualZreo()  {
        InputException exception = assertThrows(InputException.class, () -> volumeService.drawVolume(0));
        assertEquals("Input element is wrong: 0", exception.getMessage());
    }

    @Test
    public void shouldReturnVolumeById() throws BusinessException {
        // given
        long volumeId = volumeRepo.findIdByVolumeNumber(1);

        // when
        VolumeDTO volume = volumeService.findById(volumeId);

        // then
        assertEquals(1, volume.getVolumeNumber());
        assertEquals("Volume One", volume.getVolumeName());
        assertEquals("V1", volume.getVolumeShort());
        assertEquals(11, volume.getChapterAmount());
    }

    @Test
    public void shouldThrowExceptionWhenWrongId() {
        // given
        long wrongId = 301L;

        // when
        EntityNotExistException exception = assertThrows(EntityNotExistException.class, () -> volumeService.findById(wrongId));

        assertEquals("Element does not exist", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenIdIsNull() {
        // given
        Long nullId = null;

        // when
        InputException exception = assertThrows(InputException.class, () -> volumeService.findById(nullId));

        assertEquals("Input element is wrong: null", exception.getMessage());
    }

    @Test
    public void shouldFindVolumeByVolumeNumber() throws BusinessException {
        // given
        int volumeNumber = 2;

        // when
        VolumeDTO volume = volumeService.findByVolumeNumber(volumeNumber);

        // then
        assertEquals(2, volume.getVolumeNumber());
        assertEquals("Volume Two", volume.getVolumeName());
        assertEquals("V2", volume.getVolumeShort());
        assertEquals(12, volume.getChapterAmount());
    }

    @Test
    public void shouldThrowExceptionWhenWrongVolumeNumber() {
        // given
        int wrongNumber = 74;

        // when
        VolumeNumberException exception = assertThrows(VolumeNumberException.class, () -> volumeService.findByVolumeNumber(wrongNumber));

        assertEquals("Wrong volume number: 74", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenVolumeNumberIsNull() {
        // given
        Integer wrongNumber = null;

        // when
        VolumeNumberException exception = assertThrows(VolumeNumberException.class, () -> volumeService.findByVolumeNumber(wrongNumber));

        assertEquals("Wrong volume number: null", exception.getMessage());
    }

}