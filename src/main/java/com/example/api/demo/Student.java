package com.example.api.demo;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Student {
    @SerializedName("Name")
    String name;
    @SerializedName("Id")
    int id;

    @SerializedName("Age")
    int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    List<String> studentList;

    public List<String> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<String> studentList) {
        this.studentList = studentList;
    }
}
