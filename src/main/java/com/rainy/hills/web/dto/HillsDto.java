package com.rainy.hills.web.dto;

import java.util.Arrays;
import java.util.List;

public class HillsDto {
    private int[] hills;

    public int[] getHills() {
        return hills;
    }

    public void setHills(int[] hills) {
        this.hills = hills;
    }

    @Override
    public String toString() {
        return "HillsDto{" +
                "hills=" + Arrays.toString(hills) +
                '}';
    }
}
