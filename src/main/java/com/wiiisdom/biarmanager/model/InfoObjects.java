package com.wiiisdom.biarmanager.model;

import java.util.List;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "InfoObjects", namespace = "http://enterprise.businessobjects.com/4.0/infoobject")
public class InfoObjects {

    private List<InfoObject> objects;

    @XmlElements({ @XmlElement(
            name = "InfoObject",
            namespace = "http://enterprise.businessobjects.com/4.0/infoobject",
            type = InfoObject.class), })
    public List<InfoObject> getObjects() {
        return this.objects;
    }

    public void setObjects(List<InfoObject> objects) {
        this.objects = objects;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + " {" + " objects='" + getObjects() + "'" + "}\n";
    }
}