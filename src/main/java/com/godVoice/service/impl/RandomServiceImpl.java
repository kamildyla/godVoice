package com.godVoice.service.impl;

import com.godVoice.service.RandomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RandomServiceImpl implements RandomService {

    @Override
    public Integer drawOneNumber(int maxValue) {
        return (int) (Math.random() * maxValue) + 1;
    }

    @Override
    public List<Integer> drawRange(int maxValue, int maxRange) {
        return null;
    }
}
