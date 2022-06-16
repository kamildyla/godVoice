package com.godVoice.repo;

import com.godVoice.DataFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
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

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4 ,5})
    public void shouldReturnTrueForRightChapterAmount(int volumeNumber) {
        Integer chapterAmount = volumeRepo.findChapterAmountByVolumeNumber(volumeNumber);

        boolean isPresent = (chapterAmount == 11 ||
                chapterAmount == 12 ||
                chapterAmount == 13 ||
                chapterAmount == 14 ||
                chapterAmount == 15);

        assertNotNull(chapterAmount);
        assertTrue(isPresent);
    }

    @Test
    public void shouldReturnNullWhenVolumeNumberNotExist() {
        // given
        int volumeNumber = -6;

        // when
        Integer chapterAmount = volumeRepo.findChapterAmountByVolumeNumber(volumeNumber);

        // then
        assertNull(chapterAmount);
    }

    @Test
    public void shouldReturnChapterAmountByVolumeNumber() {
        // given
        Integer expected_volumeOne = 11;
        Integer expected_volumeTwo = 12;
        Integer expected_volumeThree = 13;
        Integer expected_volumeFour = 14;
        Integer expected_volumeFive = 15;

        // when
        Integer result_volumeOne = volumeRepo.findChapterAmountByVolumeNumber(1);
        Integer result_volumeTwo = volumeRepo.findChapterAmountByVolumeNumber(2);
        Integer result_volumeThree = volumeRepo.findChapterAmountByVolumeNumber(3);
        Integer result_volumeFour = volumeRepo.findChapterAmountByVolumeNumber(4);
        Integer result_volumeFive = volumeRepo.findChapterAmountByVolumeNumber(5);

        // then
        assertEquals(expected_volumeOne, result_volumeOne);
        assertEquals(expected_volumeTwo, result_volumeTwo);
        assertEquals(expected_volumeThree, result_volumeThree);
        assertEquals(expected_volumeFour, result_volumeFour);
        assertEquals(expected_volumeFive, result_volumeFive);
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
    public void shouldFindChapterAmountById() {
        // given
        Long id_volumeOne = volumeRepo.findIdByVolumeNumber(1);
        Long id_volumeTwo = volumeRepo.findIdByVolumeNumber(2);
        Long id_volumeThree = volumeRepo.findIdByVolumeNumber(3);
        Long id_volumeFour = volumeRepo.findIdByVolumeNumber(4);
        Long id_volumeFive = volumeRepo.findIdByVolumeNumber(5);

        Integer expected_volumeOne = 11;
        Integer expected_volumeTwo = 12;
        Integer expected_volumeThree = 13;
        Integer expected_volumeFour = 14;
        Integer expected_volumeFive = 15;

        // when
        Integer result_volumeOne = volumeRepo.findChapterAmountById(id_volumeOne);
        Integer result_volumeTwo = volumeRepo.findChapterAmountById(id_volumeTwo);
        Integer result_volumeThree = volumeRepo.findChapterAmountById(id_volumeThree);
        Integer result_volumeFour = volumeRepo.findChapterAmountById(id_volumeFour);
        Integer result_volumeFive = volumeRepo.findChapterAmountById(id_volumeFive);

        // then
        assertEquals(expected_volumeOne, result_volumeOne);
        assertEquals(expected_volumeTwo, result_volumeTwo);
        assertEquals(expected_volumeThree, result_volumeThree);
        assertEquals(expected_volumeFour, result_volumeFour);
        assertEquals(expected_volumeFive, result_volumeFive);
    }

    @Test
    public void shouldReturnNullIfIdNotExist() {
        // given
        Long id = -6L;

        // when
        Integer chapterAmount = volumeRepo.findChapterAmountById(id);

        // then
        assertNull(chapterAmount);
    }

}