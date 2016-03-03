package com.rainy.hills.service;

import java.util.List;

/**
 * This interface contains methods used to calculate
 * the volume of the water which is left in hills after rain.
 */
public interface VolumeCalculator {
    /**
     * Calculates the volume of water for given hills list.
     * If input is {@code null} or empty list, the {@code 0} will be returned.
     *
     * @param hills list of elevations of the hills.
     * @return calculated volume or 0 if input is {@code null} or empty list.
     */
    int calculateVolume(List<Integer> hills);
}
