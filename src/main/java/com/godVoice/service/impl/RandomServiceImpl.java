package com.godVoice.service.impl;

import com.godVoice.service.RandomService;
import com.godVoice.service.ds.RangeDs;
import com.godVoice.validation.RandomServiceValidator;
import org.springframework.stereotype.Service;

@Service
public class RandomServiceImpl implements RandomService {

    @Override
    public Integer drawOneNumber(int maxValue) {
        return (int) (Math.random() * maxValue) + 1;
    }

    @Override
    public RangeDs drawRange(int maxValue, int maxRange) {
        int valueFrom = drawOneNumber(maxValue);
        int range = drawOneNumber(maxRange) - 1;
        int valueTo = valueFrom + range;

        if (RandomServiceValidator.isRangeValid(valueTo, maxValue)) {
            return RangeDs.builder()
                    .rangeFrom(valueFrom)
                    .rangeTo(valueTo)
                    .build();
        }

        return RangeDs.builder()
                .rangeFrom(maxValue - range)
                .rangeTo(maxValue)
                .build();
    }
}
