package com.rainy.hills.unit.service;

import com.rainy.hills.service.VolumeCalculator;
import com.rainy.hills.service.VolumeCalculatorImpl;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class VolumeCalculatorTest {
    private VolumeCalculator volumeCalculator = new VolumeCalculatorImpl();

    @Test
    public void testCalculateCorrectVolume() {
        assertEquals(2, volumeCalculator.calculateVolume(new int[]{3, 2, 4, 1, 2}));

        assertEquals(8, volumeCalculator.calculateVolume(new int[]{4, 1, 1, 0, 2, 3}));

        assertEquals(1, volumeCalculator.calculateVolume(new int[]{3, 2, 4}));

        assertEquals(1, volumeCalculator.calculateVolume(new int[]{3, 2, 2, 1, 2}));

        assertEquals(6, volumeCalculator.calculateVolume(new int[]{4, 1, 3, 0, 2, 3}));

        assertEquals(7, volumeCalculator.calculateVolume(new int[]{3, 1, 4, 0, 4, 1, 2}));

        assertEquals(10, volumeCalculator.calculateVolume(new int[]{4, 1, 4, 0, 4, 1, 5}));

        assertEquals(11, volumeCalculator.calculateVolume(new int[]{4, 1, 4, 0, 4, 1, 5, 0, 1}));

        assertEquals(0, volumeCalculator.calculateVolume(new int[]{4, 3, 2, 2, 1, 1, 0}));

        assertEquals(3, volumeCalculator.calculateVolume(new int[]{4, 3, 2, 1, 3, 1, 0}));

//        assertEquals(0, volumeCalculator.calculateVolume(null));

        assertEquals(0, volumeCalculator.calculateVolume(new int[0]));
    }

    //TODO deal with this test
    @Test
    public void testCalculateVolumeLongArray() {
        int length = 1_000_000;

        int[] hills = new int[length];

        hills[0] = 1000;
        hills[hills.length - 1] = 1000;

        Random r = new Random(999);

        for (int i = 1; i < hills.length - 1; i++) {
            hills[i] = r.nextInt();
        }

        int volume = volumeCalculator.calculateVolume(hills);

        System.out.print(volume);

        Assert.assertTrue(true);
    }
}