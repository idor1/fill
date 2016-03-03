package com.rainy.hills.longdata.service;

import com.rainy.hills.service.VolumeCalculator;
import com.rainy.hills.service.VolumeCalculatorImpl;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertTrue;

public class VolumeCalculatorLongDataTest {

    private VolumeCalculator volumeCalculator = new VolumeCalculatorImpl();

    @Test
    public void testCalculateVolumeLongArray() {
        int highest = 1000;

        int length = 1_000_000;

        int[] hills = new int[length];

        hills[0] = 1000;
        hills[hills.length - 1] = 1000;

        Random r = new Random();

        for (int i = 1; i < hills.length - 1; i++) {
            hills[i] = r.nextInt(highest);
        }

        int volume = volumeCalculator.calculateVolume(hills);

        assertTrue(volume > 0);
    }
}