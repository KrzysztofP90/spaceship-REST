package com.krzysztof.spacetest.model;

import javax.persistence.*;

@Entity
@Table(name = "gender")
public class Gender {

    @Id
    @Column(name = "gender_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "genderName", nullable = false)
    private String genderName;

    public Gender() {
    }

    public int getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getGenderName() {
        return genderName;
    }

    public void setGenderName(String genderName) {
        this.genderName = genderName;
    }
}
