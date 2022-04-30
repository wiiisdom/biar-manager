package com.wiiisdom.biarmanager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.xml.bind.JAXBContext;

import com.wiiisdom.biarmanager.model.InfoObject;
import com.wiiisdom.biarmanager.model.InfoObjects;
import com.wiiisdom.biarmanager.model.LCMJob;
import com.wiiisdom.biarmanager.utils.InputStreamNoClose;

public class LCMBiarFile {

    private String file;
    private String internalLcmBiarFileName;
    private InfoObjects content;

    public LCMBiarFile(String file) {
        this.file = file;
    }

    private String getInternalLcmBiarFileName() throws FileNotFoundException, Exception {
        if (internalLcmBiarFileName == null) {
            internalLcmBiarFileName = retrieveBiarFileName();
        }
        return internalLcmBiarFileName;
    }

    public InfoObjects getIndex() throws FileNotFoundException, Exception {
        if (content == null) {
            content = retrieveBiarFileContent(this.getInternalLcmBiarFileName());
        }
        return content;
    }

    public InputStream getFile(InfoObject object, int fileOrder) throws Exception {
        String fileName = object.getCUID() + "." + String.format("%03d", fileOrder);
        return retrieveObjectFromBiar(fileName);
    }

    private String retrieveBiarFileName() throws Exception {
        final ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file));
        ZipEntry entry = zipInputStream.getNextEntry();
        while (entry != null) {
            // grabbing info from the index file
            if (entry.getName().equals("BusinessObjects.xml")) {
                final JAXBContext context = JAXBContext.newInstance(InfoObjects.class);
                final InfoObjects obj = (InfoObjects) context.createUnmarshaller()
                        .unmarshal(new InputStreamNoClose(zipInputStream));
                for (InfoObject infoObject : obj.getObjects()) {
                    if (infoObject instanceof LCMJob) {
                        LCMJob lcmJob = (LCMJob) infoObject;
                        String biarFile = lcmJob.getCUID() + "." + String.format("%03d", lcmJob.getBiarFileOrder());
                        return biarFile;
                    }
                }
            }
            // do other operation with the entries..
            entry = zipInputStream.getNextEntry();
        }
        throw new IllegalArgumentException("Can't read BusinessObjects.xml of the lcmbiar");
    }

    private InfoObjects retrieveBiarFileContent(String biarFileName) throws Exception {
        final ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file));
        ZipEntry entry = zipInputStream.getNextEntry();
        while (entry != null) {
            // open the biarFile
            if (entry.getName().equals(biarFileName)) {
                final ZipInputStream zipInputStream2 = new ZipInputStream(zipInputStream);
                ZipEntry entry2 = zipInputStream2.getNextEntry();
                while (entry2 != null) {
                    // grabbing info from the index file
                    if (entry2.getName().equals("BusinessObjects.xml")) {
                        final JAXBContext context = JAXBContext.newInstance(InfoObjects.class);
                        final InfoObjects obj = (InfoObjects) context.createUnmarshaller()
                                .unmarshal(new InputStreamNoClose(zipInputStream2));
                        return obj;
                    }
                    // do other operation with the entries..
                    entry2 = zipInputStream2.getNextEntry();
                }
            }
            // do other operation with the entries..
            entry = zipInputStream.getNextEntry();
        }
        zipInputStream.close();
        System.out.println("test");
        throw new IllegalArgumentException("Can't read BusinessObjects.xml of the inside lcmbiar.");
    }

    private InputStream retrieveObjectFromBiar(String fileName) throws Exception {
        final ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(file));
        ZipEntry entry = zipInputStream.getNextEntry();
        while (entry != null) {
            // open the biarFile
            if (entry.getName().equals(this.getInternalLcmBiarFileName())) {
                final ZipInputStream zipInputStream2 = new ZipInputStream(zipInputStream);
                ZipEntry entry2 = zipInputStream2.getNextEntry();
                while (entry2 != null) {
                    // grabbing info from the index file
                    if (entry2.getName().equals(fileName)) {
                        return zipInputStream2;
                    }
                    // do other operation with the entries..
                    entry2 = zipInputStream2.getNextEntry();
                }
            }
            // do other operation with the entries..
            entry = zipInputStream.getNextEntry();
        }
        throw new IllegalArgumentException("Can't read " + fileName + " in the inside lcmbiar");
    }
}
