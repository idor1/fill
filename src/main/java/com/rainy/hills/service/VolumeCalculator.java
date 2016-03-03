package com.rainy.hills.service;

import java.util.List;

/**
 * This interface contains methods used to calculate
 * the volume of the water which is left in hills after rain
 */
public interface VolumeCalculator {
    /**
     * Calculates the volume of water for given hills list.
     * It is VERY important to give an {@link java.util.ArrayList} but NOT {@link java.util.LinkedList} as
     * a parameter type, as a parameter of type {@link java.util.LinkedList}
     * could dramatically slow down the calculation.
     * If input is {@code null} or empty list, the {@code 0} will be returned.
     *
     * @param hills list of elevations of the hills
     * @return calculated volume for given {@code hills}
     */
    int calculateVolume(List<Integer> hills);
}
