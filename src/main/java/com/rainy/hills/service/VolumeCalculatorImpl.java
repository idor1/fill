package com.rainy.hills.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class VolumeCalculatorImpl implements VolumeCalculator {

    private static final Logger logger = LogManager.getLogger(VolumeCalculatorImpl.class);

    /**
     * {@inheritDoc}
     * <p>
     * This implementation is based on random-access list {@link java.util.Arrays.ArrayList}.
     * Be careful to pass a non-array-based list
     * such as {@link java.util.LinkedList} as
     * a parameter, because it could slow down the calculation.
     *
     * @param hills list of elevations of the hills.
     *
     * @return calculated volume or 0 if input is {@code null} or empty list.
     */
    @Override
    public int calculateVolume(List<Integer> hills) {
        logger.debug("Incoming array: " + hills);

        if (hills == null || hills.isEmpty()) {
            return 0;
        }

        int smallerBorder;
        int volume = 0;
        int j = hills.size();

        while (j > 0) {

            if (hills.get(0) > hills.get(hills.size() - 1)) {
                smallerBorder = hills.get(hills.size() - 1);
                for (int i = hills.size() - 1; i >= 0; i--) {
                    if (hills.get(i) <= smallerBorder) {
                        volume += smallerBorder - hills.get(i);
                        j--;
                    } else {
                        hills = hills.subList(0, i + 1);
                        break;
                    }
                }
            } else {
                smallerBorder = hills.get(0);
                for (int i = 0; i < hills.size(); i++) {
                    if (hills.get(i) <= smallerBorder) {
                        volume += smallerBorder - hills.get(i);
                        j--;
                    } else {
                        hills = hills.subList(i, hills.size());
                        break;
                    }
                }
            }

        }

        logger.debug("Calculated volume: " + volume);

        return volume;
    }
}
