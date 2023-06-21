package com.example.music_journal.service;

import com.example.music_journal.model.Artist;
import com.example.music_journal.model.enumerations.ArtistType;
import com.example.music_journal.model.enumerations.Genre;

import java.util.List;
import java.util.Optional;

public interface ArtistService {

    Optional<Artist> findById(Long id);
    List<Artist> findAll();
    Optional<Artist> save(String name, ArtistType artistType, Genre genre, Long albumId);
    Optional<Artist> edit(Long id, String name, ArtistType artistType, Genre genre, Long albumId);
    void deleteById(Long id);

    void save(Artist artist);
}
