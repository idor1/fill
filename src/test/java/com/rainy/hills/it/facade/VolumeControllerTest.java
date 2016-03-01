package com.rainy.hills.it.facade;

import com.rainy.hills.service.VolumeCalculator;
import com.rainy.hills.service.VolumeCalculatorImpl;
import com.rainy.hills.web.dto.HillsDto;
import com.rainy.hills.web.dto.VolumeDto;
import com.rainy.hills.web.rest.VolumeController;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URL;

@RunWith(Arquillian.class)
public class VolumeControllerTest {

    @Deployment(testable = false)
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "hills.war")
                .addClass(VolumeCalculator.class)
                .addClass(VolumeController.class)
                .addClass(HillsDto.class)
                .addClass(VolumeDto.class)
                .addClass(VolumeCalculatorImpl.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test @POST
    @Path("/volume")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public void shouldBeAbleToListACustomer(ClientResponse<VolumeDto> response)
    {
        Assert.assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        VolumeDto volumeDto = response.getEntity(VolumeDto.class);
        Assert.assertEquals(1, volumeDto.getVolume());
    }

    @Test
    public void testControllerAvailability(@ArquillianResource URL baseURI) {

        System.out.println(baseURI.getHost());
    }
}
