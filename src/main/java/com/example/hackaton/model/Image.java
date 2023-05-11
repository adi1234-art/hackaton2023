package com.example.hackaton.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Image implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 250000)
    private String imageData;

    @OneToOne(mappedBy = "image")
    private Client user;


    public String getImageData() {
        return imageData;
    }

    public void setImageData(String imageData) {
        this.imageData = imageData;
    }

}
