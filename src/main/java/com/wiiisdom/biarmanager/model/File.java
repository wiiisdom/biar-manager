package com.wiiisdom.biarmanager.model;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "File", namespace = "http://enterprise.businessobjects.com/4.0/infoobject")
public class File {

    private String name;
    private int size;

    @XmlElement(name = "Name", namespace = "http://enterprise.businessobjects.com/4.0/infoobject")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "Size")
    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "{" + " name='" + getName() + "'" + ", size='" + getSize() + "'" + "}";
    }
}
