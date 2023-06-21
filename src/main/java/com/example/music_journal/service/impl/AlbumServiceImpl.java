package com.example.music_journal.service.impl;

import com.example.music_journal.model.Album;
import com.example.music_journal.model.exceptions.AlbumNotFoundException;
import com.example.music_journal.repository.AlbumRepository;
import com.example.music_journal.service.AlbumService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public Optional<Album> findById(Long id) {
        return this.albumRepository.findById(id);
    }

    @Override
    public List<Album> listAll() {
        return this.albumRepository.findAll();
    }

    @Override
    public Optional<Album> save(String name, Integer yearRelease, String favouriteSong, Boolean isDeluxe) {
        Album album = new Album(name, yearRelease, favouriteSong, isDeluxe);
        this.albumRepository.save(album);
        return Optional.of(album);
    }

    @Override
    public Optional<Album> edit(Long id, String name, Integer yearRelease, String favouriteSong, Boolean isDeluxe) {
        Album album = this.albumRepository.findById(id).orElseThrow(() -> new AlbumNotFoundException(id));
        album.setName(name);
        album.setYearRelease(yearRelease);
        album.setFavouriteSong(favouriteSong);
        album.setIsDeluxe(isDeluxe);
        this.albumRepository.save(album);
        return Optional.of(album);
    }

    @Override
    public void deleteById(Long id) {
        this.albumRepository.deleteById(id);
    }
}
