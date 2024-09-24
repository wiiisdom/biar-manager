package com.wiiisdom.biarmanager.model;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;

public class Files {

    private List<File> files;

    @XmlElements({ @XmlElement(
            name = "File",
            namespace = "http://enterprise.businessobjects.com/4.0/infoobject",
            type = File.class), })
    public List<File> getFiles() {
        return this.files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    @Override
    public String toString() {
        return "{" + " files='" + getFiles() + "'" + "}";
    }

}
