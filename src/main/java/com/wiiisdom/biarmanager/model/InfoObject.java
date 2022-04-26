package com.wiiisdom.biarmanager.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;

@XmlSeeAlso({ Folder.class, LCMJob.class, Webi.class, CrystalReport.class, DSLUniverse.class, CCISDataConnection.class,
        UserGroup.class, CustomRole.class, Universe.class, GenericInfoObject.class, DSLDataSecurityProfile.class,
        DSLDataSecurityOptions.class, DSLBusinessSecurityOptions.class, Analytic.class, Excel.class, Word.class,
        AFDashboardPage.class, ObjectPackage.class, Txt.class, Program.class, Hyperlink.class, Publication.class,
        Powerpoint.class, Pdf.class, Agnostic.class, })

public abstract class InfoObject {

    protected String CUID;
    protected String name;
    protected String description;

    public void setCUID(String CUID) {
        this.CUID = CUID;
    }

    @XmlElement(name = "CUID", namespace = "http://enterprise.businessobjects.com/4.0/infoobject")
    public String getCUID() {
        return this.CUID;
    }

    @XmlElement(name = "Name", namespace = "http://enterprise.businessobjects.com/4.0/infoobject")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "Description", namespace = "http://enterprise.businessobjects.com/4.0/infoobject")
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " {" + " CUID='" + getCUID() + "'" + ", name='" + getName() + "'"
                + ", description='" + getDescription() + "'" + "}\n";
    }
}