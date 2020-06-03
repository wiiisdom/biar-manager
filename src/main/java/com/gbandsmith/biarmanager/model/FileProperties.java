package com.gbandsmith.biarmanager.model;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(name="FileProperties", namespace = "http://enterprise.businessobjects.com/4.0/lcmjob")
public class FileProperties {

    private Files files;

    @XmlElement(name = "Files", namespace = "http://enterprise.businessobjects.com/4.0/infoobject")
    public Files getFiles() {
        return this.files;
    }

    public void setFiles(Files files) {
        this.files = files;
    }

    @Override
    public String toString() {
        return "{" +
            " files='" + getFiles() + "'" +
            "}";
    }
}
