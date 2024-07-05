package com.springMVC.springMVC.model;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadModel {

    private MultipartFile file;
    private String name;

    // Getters and setters

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}