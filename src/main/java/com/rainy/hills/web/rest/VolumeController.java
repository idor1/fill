package com.rainy.hills.web.rest;

import com.rainy.hills.web.dto.HillsDto;
import com.rainy.hills.web.dto.VolumeDto;

/**
 * This controller performs communication between Web and volume calculation services.
 */
public class VolumeController {
    public VolumeDto calculateVolume(HillsDto hills) {
        return new VolumeDto();
    }
}
