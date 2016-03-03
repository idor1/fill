package com.rainy.hills.it.service;


import com.rainy.hills.service.VolumeCalculator;
import com.rainy.hills.service.VolumeCalculatorImpl;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;
import java.io.File;

import static junit.framework.Assert.assertEquals;

@RunWith(Arquillian.class)
public class VolumeCalculatorServiceTest {
    @EJB
    private VolumeCalculator volumeCalculator;

    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class, "hills.war")
                .addClass(VolumeCalculator.class)
                .addClass(VolumeCalculatorImpl.class)
                .addAsLibraries(new File("target/test-libs/log4j-api.jar"))
                .addAsLibraries(new File("target/test-libs/log4j-core.jar"))
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void testVolumeCalculatorServiceAvailable() {
        assertEquals(11, volumeCalculator.calculateVolume(new int[]{4, 1, 4, 0, 4, 1, 5, 0, 1}));
    }
}
