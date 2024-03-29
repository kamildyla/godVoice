package com.godVoice.service.impl;

import com.godVoice.config.PersistenceTestConfig;
import com.godVoice.service.RandomService;
import com.godVoice.service.ds.RangeDs;
import org.junit.jupiter.api.RepeatedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = PersistenceTestConfig.class)
class RandomServiceTest {

    @Autowired
    private RandomService randomService;

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

    @RepeatedTest(20)
    public void shouldDrawRangeFromGivenScope() {
        // given
        int maxValue = 50;
        int maxRange = 7;

        // when
        RangeDs result = randomService.drawRange(maxValue, maxRange);

        int resultRangeFrom = result.getRangeFrom();
        int resultRangeTo = result.getRangeTo();
        int range = resultRangeTo - resultRangeFrom;

        //then
        assertTrue(resultRangeTo <= maxValue);
        assertTrue(resultRangeFrom >= 1);
        assertTrue(resultRangeTo >= resultRangeFrom);
        assertTrue(range <= maxRange);
    }
}