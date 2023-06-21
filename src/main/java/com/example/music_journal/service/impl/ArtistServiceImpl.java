package com.example.music_journal.service.impl;

import com.example.music_journal.model.Album;
import com.example.music_journal.model.Artist;
import com.example.music_journal.model.enumerations.ArtistType;
import com.example.music_journal.model.enumerations.Genre;
import com.example.music_journal.model.exceptions.AlbumNotFoundException;
import com.example.music_journal.model.exceptions.ArtistNotFoundException;
import com.example.music_journal.repository.AlbumRepository;
import com.example.music_journal.repository.ArtistRepository;
import com.example.music_journal.service.ArtistService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;
    private final AlbumRepository albumRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository, AlbumRepository albumRepository) {
        this.artistRepository = artistRepository;
        this.albumRepository = albumRepository;
    }


    @Override
    public Optional<Artist> findById(Long id) {
        return this.artistRepository.findById(id);
    }

    @Override
    public List<Artist> findAll() {
        return this.artistRepository.findAll();
    }

    @Override
    public Optional<Artist> save(String name, ArtistType artistType, Genre genre, Long albumId) {
        Album album = this.albumRepository.findById(albumId).orElseThrow(() -> new AlbumNotFoundException(albumId));
        Artist artist = new Artist();
        artist.setName(name);
        artist.setArtistType(artistType);
        artist.setGenre(genre);
        List<Album> albums = artist.getAlbums();
        albums.add(album);
        Artist artist1 = new Artist(artist.getName(),artist.getArtistType(), artist.getGenre(), albums);
        this.artistRepository.save(artist1);
        return Optional.of(artist);
    }

    @Override
    public Optional<Artist> edit(Long id, String name, ArtistType artistType, Genre genre, Long albumId) {
        Album album = this.albumRepository.findById(albumId).orElseThrow(() -> new AlbumNotFoundException(albumId));
        Artist artist = this.artistRepository.findById(id).orElseThrow(() -> new ArtistNotFoundException(id));
        artist.setName(name);
        artist.setArtistType(artistType);
        artist.setGenre(genre);
        List<Album> albums = artist.getAlbums();
        albums.add(album);
        this.artistRepository.save(artist);
        return Optional.of(artist);
    }

    @Override
    public void deleteById(Long id) {
        this.artistRepository.deleteById(id);
    }

    @Override
    public void save(Artist artist) {
        this.artistRepository.save(artist);
    }
}
