package com.rainy.hills.longdata.service;

import com.rainy.hills.service.VolumeCalculator;
import com.rainy.hills.service.VolumeCalculatorImpl;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class VolumeCalculatorLongDataTest {

    private VolumeCalculator volumeCalculator = new VolumeCalculatorImpl();

    @Test
    public void testCalculateVolumeLongList() {
        int highest = 10;

        int length = 10_000_000;

        List<Integer> hills = new ArrayList<>();

        hills.add(highest);

        Random r = new Random();

        for (int i = 1; i < length - 1; i++) {
            hills.add(r.nextInt(highest - 1));
        }

        hills.add(highest);

        int volume = volumeCalculator.calculateVolume(hills);

        assertTrue(volume > 0);
    }
}