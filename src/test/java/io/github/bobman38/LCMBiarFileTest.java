package io.github.bobman38;

import org.junit.Assert;
import org.junit.Test;

import io.github.bobman38.model.InfoObjects;

public class LCMBiarFileTest {

    @Test
    public void readSQLServerAuditingLcmbiar() {
        try {
            LCMBiarFile lcmbiar = new LCMBiarFile("src/test/resources/SQLServerAuditing.lcmbiar");
            InfoObjects index = lcmbiar.getIndex();
            Assert.assertNotNull(index);
            Assert.assertEquals(57, index.getObjects().size());
        }
        catch(Exception e) {
            e.printStackTrace();
            Assert.fail("Exception");
        }
    }

    @Test
    public void readBudgetWebLcmbiar() {
        try {
            LCMBiarFile lcmbiar = new LCMBiarFile("src/test/resources/budgetweb.lcmbiar");
            InfoObjects index = lcmbiar.getIndex();
            Assert.assertNotNull(index);
            Assert.assertEquals(14, index.getObjects().size());
        }
        catch(Exception e) {
            e.printStackTrace();
            Assert.fail("Exception");
        }
    }

    @Test
    public void readWebiSampleLcmbiar() {
        try {
            LCMBiarFile lcmbiar = new LCMBiarFile("src/test/resources/LCM_BIAR_File_With_Refresh_Sample_Webi_Reports.lcmbiar");
            InfoObjects index = lcmbiar.getIndex();
            Assert.assertNotNull(index);
            Assert.assertEquals(23, index.getObjects().size());
        }
        catch(Exception e) {
            e.printStackTrace();
            Assert.fail("Exception");
        }
    }

    @Test
    public void readBIRAUnxLcmbiar() {
        try {
            LCMBiarFile lcmbiar = new LCMBiarFile("src/test/resources/BIRA-RTM-423002-UnxSample.lcmbiar");
            InfoObjects index = lcmbiar.getIndex();
            Assert.assertNotNull(index);
            Assert.assertEquals(8, index.getObjects().size());
        }
        catch(Exception e) {
            e.printStackTrace();
            Assert.fail("Exception");
        }
    }

    @Test
    public void readBIRAWebiLcmbiar() {
        try {
            LCMBiarFile lcmbiar = new LCMBiarFile("src/test/resources/BIRA-RTM-423002-WebISamples.lcmbiar");
            InfoObjects index = lcmbiar.getIndex();
            Assert.assertNotNull(index);
            Assert.assertEquals(21, index.getObjects().size());
        }
        catch(Exception e) {
            e.printStackTrace();
            Assert.fail("Exception");
        }
    }


}