package io.github.bobman38;

import java.io.FileNotFoundException;

import org.junit.Assert;
import org.junit.Test;

import io.github.bobman38.model.InfoObjects;

public class LCMBiarFileTest {

    @Test
    public void readSQLServerAuditingLcmbiar() throws FileNotFoundException, Exception {
        LCMBiarFile lcmbiar = new LCMBiarFile("src/test/resources/SQLServerAuditing.lcmbiar");
        InfoObjects index = lcmbiar.getIndex();
        Assert.assertNotNull(index);
        Assert.assertEquals(57, index.getObjects().size());
    }

    @Test
    public void readBudgetWebLcmbiar() throws FileNotFoundException, Exception {
        LCMBiarFile lcmbiar = new LCMBiarFile("src/test/resources/budgetweb.lcmbiar");
        InfoObjects index = lcmbiar.getIndex();
        Assert.assertNotNull(index);
        Assert.assertEquals(14, index.getObjects().size());
    }

    @Test
    public void readWebiSampleLcmbiar() throws FileNotFoundException, Exception {
        LCMBiarFile lcmbiar = new LCMBiarFile("src/test/resources/LCM_BIAR_File_With_Refresh_Sample_Webi_Reports.lcmbiar");
        InfoObjects index = lcmbiar.getIndex();
        Assert.assertNotNull(index);
        Assert.assertEquals(23, index.getObjects().size());
    }

    @Test
    public void readBIRAUnxLcmbiar() throws FileNotFoundException, Exception {
        LCMBiarFile lcmbiar = new LCMBiarFile("src/test/resources/BIRA-RTM-423002-UnxSample.lcmbiar");
        InfoObjects index = lcmbiar.getIndex();
        Assert.assertNotNull(index);
        Assert.assertEquals(8, index.getObjects().size());
    }

    @Test
    public void readBIRAWebiLcmbiar() throws FileNotFoundException, Exception {
        LCMBiarFile lcmbiar = new LCMBiarFile("src/test/resources/BIRA-RTM-423002-WebISamples.lcmbiar");
        InfoObjects index = lcmbiar.getIndex();
        Assert.assertNotNull(index);
        Assert.assertEquals(21, index.getObjects().size());
    }

    @Test
    public void readBiarManagerTest() throws FileNotFoundException, Exception {
        LCMBiarFile lcmbiar = new LCMBiarFile("src/test/resources/biarManagerTest.lcmbiar");
        InfoObjects index = lcmbiar.getIndex();
        Assert.assertNotNull(index);
        Assert.assertEquals(28, index.getObjects().size());
    }


}