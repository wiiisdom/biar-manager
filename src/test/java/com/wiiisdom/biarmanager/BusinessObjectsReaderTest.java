package com.wiiisdom.biarmanager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;

import com.wiiisdom.biarmanager.model.InfoObjects;
import com.wiiisdom.biarmanager.model.LCMJob;

import org.junit.Test;

public class BusinessObjectsReaderTest {

    @Test
    public void readBusinessObjectXmlFirst() throws FileNotFoundException, JAXBException {
        final JAXBContext context = JAXBContext.newInstance(InfoObjects.class);
        final InfoObjects obj = (InfoObjects) context.createUnmarshaller()
                .unmarshal(new FileInputStream("src/test/resources/BusinessObjects-first.xml"));
        assertNotNull(obj);
        assertEquals(4, obj.getObjects().size());
        LCMJob lcmbiar = (LCMJob) obj.getObjects().get(3);
        assertEquals("SQLServerAuditing", lcmbiar.getName());
        assertNotNull("file collection is null", lcmbiar.getFiles());
        assertEquals(5, lcmbiar.getFiles().size());
    }
}