package com.godVoice.service.impl;

import com.godVoice.DataFactory;
import com.godVoice.config.PersistenceTestConfig;
import com.godVoice.exceptions.BusinessException;
import com.godVoice.exceptions.EntityNotExistException;
import com.godVoice.exceptions.InputException;
import com.godVoice.repo.ChapterRepository;
import com.godVoice.service.ChapterService;
import com.godVoice.service.VolumeService;
import com.godVoice.types.ChapterDTO;
import com.godVoice.types.VolumeDTO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = PersistenceTestConfig.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ChapterServiceImplTest {

    @Autowired
    private DataFactory dataFactory;
    @Autowired
    private ChapterService chapterService;
    @Autowired
    private ChapterRepository chapterRepo;
    @Autowired
    private VolumeService volumeService;

    @BeforeAll
    public void setUp() {
        dataFactory.loadVolumesAndChapters();
    }

    @AfterAll
    public void cleanUp() {
        dataFactory.deleteVolumesAndChapters();
    }

    @Test
    public void should() {

    }

    @Test
    public void shouldReturnChapterById() throws BusinessException {
        // given
        long chapterId = chapterRepo.findIdByChapterAndVolumeNumber(3, 2);

        // when
        ChapterDTO chapter = chapterService.findById(chapterId);

        // then
        assertEquals(chapterId, chapter.getId());
        assertEquals(3, chapter.getChapter());
        assertEquals(32, chapter.getVerses());
    }

    @Test
    public void shouldThrowExceptionIfWrongId() {
        // given
        long wrongId = 70000L;

        // when
        EntityNotExistException exception = assertThrows(EntityNotExistException.class, () -> chapterService.findById(wrongId));

        // then
        assertEquals("Element does not exist", exception.getMessage());
    }

    @Test
    public void shouldThrowExceptionIfIdIsNull() {
        // given
        Long nullId = null;

        // when
        InputException exception = assertThrows(InputException.class, () -> chapterService.findById(nullId));

        // then
        assertEquals("Input element is wrong: null", exception.getMessage());
    }

    @RepeatedTest(20)
    public void shouldDrawChapterFromVolume() throws BusinessException {
        // given
        VolumeDTO volume = volumeService.findByVolumeNumber(4);

        // when
        ChapterDTO chapter = chapterService.drawChapterFromVolume(volume);
        Integer chapterNumber = chapter.getChapter();
        Integer verses = chapter.getVerses();

        // then
        assertNotNull(chapter.getChapter());
        assertNotNull(chapter.getVerses());
        assertTrue(chapterNumber >= 1 && chapterNumber <= 14);
        assertTrue(verses >= 50 && verses <= 64);
    }

    @Test
    public void shouldThrowExceptionWhenVolumeIsNull() {
        // given
        VolumeDTO volume = null;

        // when
        InputException exception = assertThrows(InputException.class, () -> chapterService.drawChapterFromVolume(volume));

        // then
        assertEquals("Input element is wrong: null", exception.getMessage());

    }

}