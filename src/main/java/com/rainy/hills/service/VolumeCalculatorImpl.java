package com.rainy.hills.service;

import javax.ejb.Stateless;
import java.util.Arrays;

@Stateless
public class VolumeCalculatorImpl implements VolumeCalculator {
    @Override
    public int calculateVolume(int[] hills) {
        if (hills == null || hills.length == 0) {
            return 0;
        }
        int smallerBorder;
        int volume = 0;
        int j = hills.length;
        while (j > 0) {

            if (hills[0] > hills[hills.length - 1]) {

                smallerBorder = hills[hills.length - 1];
                for (int i = hills.length - 1; i >= 0; i--) {
                    if (hills[i] <= smallerBorder) {
                        volume += smallerBorder - hills[i];
                        j--;
                    } else {
                        hills = Arrays.copyOfRange(hills, 0, i + 1);
                        break;
                    }
                }
            } else {
                smallerBorder = hills[0];
                for (int i = 0; i < hills.length; i++) {
                    if (hills[i] <= smallerBorder) {
                        volume += smallerBorder - hills[i];
                        j--;
                    } else {
                        hills = Arrays.copyOfRange(hills, i, hills.length);
                        break;
                    }
                }
            }
        }
        return volume;
    }
}
