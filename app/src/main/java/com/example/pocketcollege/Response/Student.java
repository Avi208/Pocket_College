package com.example.pocketcollege.Response;

public class Student {
    private String name;
    private int photoId; // Resource ID for the image
    private String registerNumber;
    private String branch;

    public Student(String name, int photoId, String registerNumber, String branch) {
        this.name = name;
        this.photoId = photoId;
        this.registerNumber = registerNumber;
        this.branch = branch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }
}
