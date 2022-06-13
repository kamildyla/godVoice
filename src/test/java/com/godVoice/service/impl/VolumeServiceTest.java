package com.godVoice.service.impl;

import com.godVoice.DataFactory;
import com.godVoice.exceptions.EntityNotExistException;
import com.godVoice.service.VolumeService;
import com.godVoice.types.VolumeDTO;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class VolumeServiceTest {

    @Autowired
    private DataFactory dataFactory;
    @Autowired
    private VolumeService volumeService;

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
    public void shouldReturnRandomVolume() throws EntityNotExistException {
        // given when
        VolumeDTO volume = volumeService.drawVolume(VOLUMES_AMOUNT);
        int result = volume.getVolumeNumber();
        System.out.println(result);
        // then
        assertTrue(result >= 1 && result <= 5);
    }

}