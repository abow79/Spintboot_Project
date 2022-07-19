package com.example.api.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController2 {
    @RequestMapping(value = "/student")
    public Student parameters4(){
        Student student=new Student();
        //student.setName("Judy");
        //student.setId(1);
        List<String> list=new ArrayList<>();
        list.add("Hank");
        list.add("Kevin");
        list.add("Abow");
        student.setStudentList(list);
        return student;
    }
}
