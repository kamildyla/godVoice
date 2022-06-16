package com.godVoice.service;

import com.godVoice.service.ds.RangeDs;

public interface RandomService {

    Integer drawOneNumber(int maxValue);

    RangeDs drawRange(int maxValue, int maxRange);

}
