package com.rainy.hills.web.rest;

import com.rainy.hills.service.VolumeCalculator;
import com.rainy.hills.web.dto.HillsDto;
import com.rainy.hills.web.dto.VolumeDto;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * This controller performs communication between Web and volume calculation services.
 */
@Path("/volume")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VolumeController {
    @EJB
    private VolumeCalculator volumeCalculator;

    @POST
    public VolumeDto calculateVolume(HillsDto hillsDto) {
        int volume = volumeCalculator.calculateVolume(hillsDto.getHills());

        VolumeDto volumeDto = new VolumeDto();

        volumeDto.setVolume(volume);

        return volumeDto;
    }
}
