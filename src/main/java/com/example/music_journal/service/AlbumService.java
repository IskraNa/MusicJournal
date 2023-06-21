package com.example.music_journal.service;

import com.example.music_journal.model.Album;

import java.util.List;
import java.util.Optional;

public interface AlbumService {

    Optional<Album> findById(Long id);
    List<Album> listAll();
    Optional<Album> save(String name, Integer yearRelease, String favouriteSong, Boolean isDeluxe);
    Optional<Album> edit(Long id, String name, Integer yearRelease, String favouriteSong, Boolean isDeluxe);
    void deleteById(Long id);
}
