package com.godVoice.service.impl;

import com.godVoice.DataFactory;
import com.godVoice.exceptions.BusinessException;
import com.godVoice.repo.ChapterRepository;
import com.godVoice.service.ChapterService;
import com.godVoice.types.ChapterDTO;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ChapterServiceImplTest {

    @Autowired
    private DataFactory dataFactory;
    @Autowired
    private ChapterService chapterService;
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

}