package com.rainy.hills.it.facade;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rainy.hills.service.VolumeCalculator;
import com.rainy.hills.service.VolumeCalculatorImpl;
import com.rainy.hills.web.dto.HillsDto;
import com.rainy.hills.web.dto.VolumeDto;
import com.rainy.hills.web.rest.VolumeController;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.ContentType;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

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
                .setWebXML(new File("src/main/webapp/WEB-INF/web.xml"))
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void testVolumeEndpoint(@ArquillianResource URL baseUrl) throws IOException, URISyntaxException {
        HillsDto hillsDto = new HillsDto();

        hillsDto.setHills(new int[]{2, 0, 4});

        ObjectMapper objectMapper = new ObjectMapper();

        String body = objectMapper.writeValueAsString(hillsDto);

        Response postResponse = Request.Post(baseUrl + "rest/volume")
                .bodyString(body, ContentType.APPLICATION_JSON)
                .execute();

        String responseStr = postResponse.returnContent().asString();

        VolumeDto volumeDto = objectMapper.readValue(responseStr, VolumeDto.class);

        assertEquals(2, volumeDto.getVolume());
    }

    @Test
    public void testControllerAvailability(@ArquillianResource URL baseURI) {

        System.out.println(baseURI);
    }
}
