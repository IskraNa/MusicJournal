package com.example.music_journal.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Data
public class Album{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "yearReleased")
    private Integer yearRelease;

    @Column(name = "favouriteSong")
    private String favouriteSong;

    @Column(name = "isDeluxe")
    private Boolean isDeluxe;

    public Album(String name, int yearRelease, String favouriteSong, Boolean isDeluxe) {
        this.name = name;
        this.yearRelease = yearRelease;
        this.favouriteSong = favouriteSong;
        this.isDeluxe = isDeluxe;
    }

    public Album() {

    }
}
