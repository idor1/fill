package com.rainy.hills.web.dto;

public class VolumeDto {
    private int volume;

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "VolumeDto{" +
                "volume=" + volume +
                '}';
    }
}
