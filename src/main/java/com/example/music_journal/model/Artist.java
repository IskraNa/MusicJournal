package com.example.music_journal.model;

import com.example.music_journal.model.enumerations.ArtistType;
import com.example.music_journal.model.enumerations.Genre;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    private ArtistType artistType;

    @Column(name = "genre")
    @Enumerated(value = EnumType.ORDINAL)
    private Genre genre;

    @Column(name = "albums")
    @ManyToMany
    private List<Album> albums;

    public Artist(String name, ArtistType artistType, Genre genre, List<Album> albums) {
        this.name = name;
        this.artistType = artistType;
        this.genre = genre;
        this.albums = albums;
    }

    public Artist() {
        this.albums = new ArrayList<>();
    }


}
