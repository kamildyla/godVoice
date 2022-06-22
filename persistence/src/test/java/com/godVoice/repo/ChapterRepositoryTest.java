package com.godVoice.repo;

import com.godVoice.DataFactory;
import com.godVoice.config.PersistenceTestConfig;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = PersistenceTestConfig.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ChapterRepositoryTest {

    @Autowired
    private DataFactory dataFactory;
    @Autowired
    private ChapterRepository chapterRepo;

    @BeforeAll
    public void setUp() {
        dataFactory.loadVolumesAndChapters();
    }

    @AfterAll
    public void cleanUp() {
        dataFactory.deleteVolumesAndChapters();
    }

    @Test
    public void shouldFindIdByChapterAndVolumeNumber() {
        // given
        int chapterNumber = 2;
        int volumeNumber = 2;

        // when
        Long returnedId = chapterRepo.findIdByChapterAndVolumeNumber(chapterNumber, volumeNumber);

        // then
        assertNotNull(returnedId);
        assertEquals(Long.class, returnedId.getClass());
    }

    @Test
    public void shouldReturnNullWhenVolumeNumberNotExist() {
        // given
        int chapterNumber = 2;
        int volumeNumber = 6;

        // when
        Long returnedId = chapterRepo.findIdByChapterAndVolumeNumber(chapterNumber, volumeNumber);

        // then
        assertNull(returnedId);
    }

    @Test
    public void shouldReturnNullWhenChapterNumberNotExist() {
        // given
        int chapterNumber = -50;
        int volumeNumber = 1;

        // when
        Long returnedId = chapterRepo.findIdByChapterAndVolumeNumber(chapterNumber, volumeNumber);

        // then
        assertNull(returnedId);
    }

    @Test
    public void shouldReturnNullWhenInputIsNull() {
        // given
        Integer chapterNumber = null;
        Integer volumeNumber = null;

        // when
        Long returnedId = chapterRepo.findIdByChapterAndVolumeNumber(chapterNumber, volumeNumber);

        // then
        assertNull(returnedId);
    }

}