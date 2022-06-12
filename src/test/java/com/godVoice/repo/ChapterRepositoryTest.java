package com.godVoice.repo;

import com.godVoice.DataFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
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

    // TODO to improve
    @Test
    public void should() {
        Long id = chapterRepo.findIdByChapterAndVolumeNumber(2, 2);
        System.out.println(id); // 13
    }

}