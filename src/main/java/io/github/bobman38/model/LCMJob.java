package io.github.bobman38.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "LCMJob", namespace = "http://enterprise.businessobjects.com/4.0/lcmjob")
public class LCMJob extends InfoObject {

    private FileProperties fileProperties;

    @XmlElement(name="FileProperties", namespace="http://enterprise.businessobjects.com/4.0/lcmjob")
    public FileProperties getFileProperties() {
        return this.fileProperties;
    }

    public void setFileProperties(FileProperties fileProperties) {
        this.fileProperties = fileProperties;
    }

    public List<File> getFiles() {
        if(this.getFileProperties() == null || this.getFileProperties().getFiles() == null || this.getFileProperties().getFiles().getFiles() == null) {
            throw new IllegalArgumentException("No files in LCMJob");
        }
        return this.getFileProperties().getFiles().getFiles();
    }

    public int getBiarFileOrder() {
        int fileOrder = 0;
        for (File file : this.getFiles()) {
            // start by 1 not 0
            fileOrder++;
            if(file.getName().endsWith(".lcmbiar")) {
                return fileOrder;
            }
        }
        throw new IllegalArgumentException("No lcmbiar file in this LCMJob");
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+"{" +
            " CUID='" + getCUID() + "'" +
            ", name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", fileProperties='" + getFileProperties() + "'" +
            "}\n";
    }
}