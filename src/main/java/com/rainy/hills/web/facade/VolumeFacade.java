package com.rainy.hills.web.facade;

import com.rainy.hills.web.dto.HillsDto;
import com.rainy.hills.web.dto.VolumeDto;

/**
 * This facade performs communication between Web and volume calculation services.
 */
public class VolumeFacade {
    public VolumeDto calculateVolume(HillsDto hills) {
        return new VolumeDto();
    }
}
