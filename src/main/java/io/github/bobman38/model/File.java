package io.github.bobman38.model;

import java.util.Objects;

import javax.xml.bind.annotation.XmlElement;

public class File {
    @XmlElement(name="Name", namespace = "http://enterprise.businessobjects.com/4.0/infoobject")
    private String name;

    @XmlElement(name="Size")
    private int size;

    public File() {
    }

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return this.size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public File name(String name) {
        this.name = name;
        return this;
    }

    public File size(int size) {
        this.size = size;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof File)) {
            return false;
        }
        File file = (File) o;
        return Objects.equals(name, file.name) && size == file.size;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, size);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", size='" + getSize() + "'" +
            "}";
    }



}
