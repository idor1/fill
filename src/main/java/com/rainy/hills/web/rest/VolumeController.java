package com.rainy.hills.web.rest;

import com.rainy.hills.service.VolumeCalculator;
import com.rainy.hills.web.dto.HillsDto;
import com.rainy.hills.web.dto.VolumeDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * This controller performs communication between Web and volume calculation services.
 */
@Path("/volume")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VolumeController {
    private static final Logger logger = LogManager.getLogger(VolumeController.class);

    @EJB
    private VolumeCalculator volumeCalculator;

    @POST
    public Response calculateVolume(HillsDto hillsDto) {
        logger.info("Incoming DTO: " + hillsDto);

        if (hillsDto == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        int volume = volumeCalculator.calculateVolume(hillsDto.getHills());

        VolumeDto volumeDto = new VolumeDto();

        volumeDto.setVolume(volume);

        logger.info("Outgoing DTO: " + volumeDto);

        return Response.status(Response.Status.OK).entity(volumeDto).build();
    }
}
