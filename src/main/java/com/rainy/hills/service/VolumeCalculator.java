package com.rainy.hills.service;

import java.util.List;

/**
 * This interface contains methods used to calculate
 * the volume of the water which is left in hills after rain
 */
public interface VolumeCalculator {
    /**
     * Calculates the volume of water for given hills array.
     * If input is {@code null} or empty array, the {@code 0} will be returned.
     * @param hills array of elevations of the hills
     * @return calculated volume for given {@code hills}
     */
    int calculateVolume(List<Integer> hills);

    int calculateVolume(int[] hills);
}
