package com.godVoice.service.impl;

import com.godVoice.service.RandomService;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class RandomServiceImplTest {

    @Autowired
    RandomService randomService;

    @RepeatedTest(20)
    public void shouldDrawNumberFromOneToTen() {
        // given
        int min = 1;
        int max = 10;

        // when
        int result = randomService.drawOneNumber(max);

        // then
        assertTrue(min <= result  && result <= max);
    }

}