package com.example.api.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name = "\"Human\"")
public class Human {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "\"Id\"", nullable = false)
    private Long id;

    @Column(name = "\"ChineseName\"", nullable = false, length = 20)
    private String chineseName;

    @Column(name = "\"EnglishName\"", nullable = false, length = 20)
    private String englishName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getChineseName() {
        return chineseName;
    }

    public void setChineseName(String chineseName) {
        this.chineseName = chineseName;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

}