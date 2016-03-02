package com.rainy.hills.web.rest;

import com.rainy.hills.service.VolumeCalculator;
import com.rainy.hills.web.dto.HillsDto;
import com.rainy.hills.web.dto.VolumeDto;
import org.apache.log4j.Logger;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.Collections;

/**
 * This controller performs communication between Web and volume calculation services.
 */
@Path("/volume")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VolumeController {

    private static Logger logger = Logger.getLogger(VolumeController.class);

    @EJB
    private VolumeCalculator volumeCalculator;

    @POST
//    @Path("/volume")
    public VolumeDto calculateVolume(HillsDto hillsDto) {

        logger.trace(hillsDto);

        int volume = volumeCalculator.calculateVolume(hillsDto.getHills());

        VolumeDto volumeDto = new VolumeDto();

        volumeDto.setVolume(volume);

        return volumeDto;
    }
}
