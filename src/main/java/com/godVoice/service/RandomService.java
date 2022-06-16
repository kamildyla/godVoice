package com.godVoice.service;

import com.godVoice.service.ds.Range;

public interface RandomService {

    Integer drawOneNumber(int maxValue);

    Range drawRange(int maxValue, int maxRange);

}
