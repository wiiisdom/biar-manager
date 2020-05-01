package io.github.bobman38.model;

import java.util.Objects;
import javax.xml.bind.annotation.XmlSeeAlso;
import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlSeeAlso({
    Folder.class, 
    LCMJob.class, 
    Webi.class,
    CrystalReport.class,
    DSLUniverse.class,
    CCISDataConnection.class,
    UserGroup.class,
    CustomRole.class,
    Universe.class,
    GenericInfoObject.class,
    DSLDataSecurityProfile.class
    })
public abstract class InfoObject {

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+"{" +
            " CUID='" + getCUID() + "'" +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            "}\n";
    }

    @XmlPath(value = "io:CUID/text()")
    protected String CUID;

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    @XmlPath(value = "io:Name/text()")
    protected String name;

    @XmlPath(value = "io:Description/text()")
    protected String description;

    public InfoObject() {
    }

    public InfoObject(String CUID) {
        this.CUID = CUID;
    }

    public String getCUID() {
        return this.CUID;
    }

    public void setCUID(String CUID) {
        this.CUID = CUID;
    }

    public InfoObject CUID(String CUID) {
        this.CUID = CUID;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof InfoObject)) {
            return false;
        }
        InfoObject infoObject = (InfoObject) o;
        return Objects.equals(CUID, infoObject.CUID);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(CUID);
    }

}