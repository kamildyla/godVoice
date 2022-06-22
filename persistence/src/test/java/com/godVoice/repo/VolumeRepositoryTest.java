package com.godVoice.repo;

import com.godVoice.DataFactory;
import com.godVoice.config.PersistenceTestConfig;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest(classes = PersistenceTestConfig.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class VolumeRepositoryTest {

    @Autowired
    private DataFactory dataFactory;
    @Autowired
    private VolumeRepository volumeRepo;

    @BeforeAll
    public void setUp() {
        dataFactory.loadVolumesAndChapters();
    }

    @AfterAll
    public void cleanUp() {
        dataFactory.deleteVolumesAndChapters();
    }

    @Test
    public void shouldFindIdByProperVolumeNumber() {
        assertNotNull(volumeRepo.findIdByVolumeNumber(1));
        assertNotNull(volumeRepo.findIdByVolumeNumber(2));
        assertNotNull(volumeRepo.findIdByVolumeNumber(3));
        assertNotNull(volumeRepo.findIdByVolumeNumber(4));
        assertNotNull(volumeRepo.findIdByVolumeNumber(5));
    }

    @Test
    public void shouldReturnNullIfWrongVolumeNumber() {
        // given
        int volumeNumber = -6;

        // when
        Long volumeId = volumeRepo.findIdByVolumeNumber(volumeNumber);

        // then
        assertNull(volumeId);
    }

    @Test
    public void shouldReturnNullIfInputIsNull() {
        // given
        Integer volumeNumber = null;

        // when
        Long volumeId = volumeRepo.findIdByVolumeNumber(volumeNumber);

        // then
        assertNull(volumeId);
    }

}