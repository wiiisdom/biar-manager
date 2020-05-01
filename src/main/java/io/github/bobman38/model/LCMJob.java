package io.github.bobman38.model;

import java.util.List;
import java.util.Objects;

import javax.xml.bind.annotation.XmlType;
import org.eclipse.persistence.oxm.annotations.XmlPath;

@XmlType(name = "LCMJob", namespace = "http://enterprise.businessobjects.com/4.0/lcmjob")

public class LCMJob extends InfoObject {

    @XmlPath(value = "lcmj:FileProperties/io:Files/io:File")
    private List<File> files;

    public LCMJob() {
    }

    public LCMJob(List<File> files) {
        this.files = files;
    }

    public List<File> getFiles() {
        return this.files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public LCMJob files(List<File> files) {
        this.files = files;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof LCMJob)) {
            return false;
        }
        LCMJob lCMJob = (LCMJob) o;
        return Objects.equals(files, lCMJob.files);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(files);
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

}