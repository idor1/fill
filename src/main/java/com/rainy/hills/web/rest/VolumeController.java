package com.rainy.hills.web.rest;

import com.rainy.hills.web.dto.HillsDto;
import com.rainy.hills.web.dto.VolumeDto;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * This controller performs communication between Web and volume calculation services.
 */
@Path("/volume")
@Produces(MediaType.APPLICATION_JSON)
//@Consumes(MediaType.APPLICATION_JSON)
public class VolumeController {
    @GET
    public String calculateVolume() {
        return "Test ok";
    }
}
