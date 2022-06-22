package com.godVoice.service;

import com.godVoice.service.ds.RangeDs;

/**
 * Service for draw random numbers.
 */
public interface RandomService {

    /**
     * Draws one number (from 1 to given max value).
     * @param maxValue max value.
     * @return drawned number.
     */
    Integer drawOneNumber(int maxValue);

    /**
     * Draws a random range of numbers (from 1 to given max value).
     * @param maxValue max value.
     * @param maxRange max span of numbers.
     * @return range - value 'from' and 'to'.
     */
    RangeDs drawRange(int maxValue, int maxRange);

}
