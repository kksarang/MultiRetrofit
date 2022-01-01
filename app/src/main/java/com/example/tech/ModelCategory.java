package com.example.tech;

public class ModelCategory {

    private String name;
    private String number_of_courses;
    private String thumbnail;

    public ModelCategory(String name, String number_of_courses, String thumbnail) {
        this.name = name;
        this.number_of_courses = number_of_courses;
        this.thumbnail = thumbnail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber_of_courses() {
        return number_of_courses;
    }

    public void setNumber_of_courses(String number_of_courses) {
        this.number_of_courses = number_of_courses;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
