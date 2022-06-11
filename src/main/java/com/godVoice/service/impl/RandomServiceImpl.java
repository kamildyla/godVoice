package com.godVoice.service.impl;

import com.godVoice.service.RandomService;
import com.godVoice.service.ds.Range;
import com.godVoice.validation.RandomServiceValidator;
import org.springframework.stereotype.Service;

@Service
public class RandomServiceImpl implements RandomService {

    @Override
    public Integer drawOneNumber(int maxValue) {
        return (int) (Math.random() * maxValue) + 1;
    }

    @Override
    public Range drawRange(int maxValue, int maxRange) {
        // TODO maxRange = 7 for verses
        int valueFrom = drawOneNumber(maxValue);
        int range = drawOneNumber(maxRange) - 1;
        int valueTo = valueFrom + range;

        if (RandomServiceValidator.isRangeValid(valueTo, maxValue)) {
            return Range.builder()
                    .rangeFrom(valueFrom)
                    .rangeTo(valueTo)
                    .build();
        }

        return Range.builder()
                .rangeFrom(maxValue - range)
                .rangeTo(maxValue)
                .build();
    }
}
