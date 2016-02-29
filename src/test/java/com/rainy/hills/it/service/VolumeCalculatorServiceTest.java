package com.rainy.hills.it.service;


import com.rainy.hills.unit.service.VolumeCalculator;
import com.rainy.hills.unit.service.VolumeCalculatorImpl;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.ejb.EJB;

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
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Test
    public void testVolumeCalculationPossible() {
        assertEquals(0, volumeCalculator.calculateVolume(new int[]{}));
    }
}
