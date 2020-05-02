package io.github.bobman38;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import org.junit.Test;

import io.github.bobman38.model.InfoObjects;
import io.github.bobman38.model.LCMJob;

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