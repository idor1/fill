package com.rainy.hills.web.dto;

import java.util.List;

public class HillsDto {
    private List<Integer> hills;

    public List<Integer> getHills() {
        return hills;
    }

    public void setHills(List<Integer> hills) {
        this.hills = hills;
    }

    @Override
    public String toString() {
        return "HillsDto{" +
                "hills=" + hills +
                '}';
    }
}
