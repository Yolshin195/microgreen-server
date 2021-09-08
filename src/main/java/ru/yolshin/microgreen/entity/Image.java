package ru.yolshin.microgreen.entity;

import javax.persistence.*;

@Entity(name = "microgreen_image")
@Table(name = "microgreen_image")
public class Image extends AbstractEntity {
    private String fileName;
    private String originFileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getOriginFileName() {
        return originFileName;
    }

    public void setOriginFileName(String originFileName) {
        this.originFileName = originFileName;
    }
}
