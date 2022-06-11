package com.godVoice.service;

import java.util.List;

public interface RandomService {

    Integer drawOneNumber(int maxValue);

    List<Integer> drawRange(int maxValue, int maxRange);

}
