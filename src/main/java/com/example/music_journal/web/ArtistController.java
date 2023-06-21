package com.example.music_journal.web;

import com.example.music_journal.model.Album;
import com.example.music_journal.model.Artist;
import com.example.music_journal.model.enumerations.ArtistType;
import com.example.music_journal.model.enumerations.Genre;
import com.example.music_journal.model.exceptions.ArtistNotFoundException;
import com.example.music_journal.service.AlbumService;
import com.example.music_journal.service.ArtistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ArtistController {

    private final ArtistService artistService;
    private final AlbumService albumService;

    public ArtistController(ArtistService artistService, AlbumService albumService) {
        this.artistService = artistService;
        this.albumService = albumService;
    }

    @GetMapping("/artists")
    public String findAll(Model model){
        List<Artist> artists = this.artistService.findAll();
        List<Album> albumList = this.albumService.listAll();
        model.addAttribute("artists", artists);
        model.addAttribute("types", ArtistType.values());
        model.addAttribute("genres", Genre.values());
        model.addAttribute("albums", albumList);
        return "artists.html";
    }

    @GetMapping("/artists/{id}")
    public String findById(@PathVariable Long id){

        return "";
    }

    @GetMapping("/artists/add")
    public String showAdd(Model model){
        List<Album> albumList = this.albumService.listAll();
        model.addAttribute("albums", albumList);
        model.addAttribute("types", ArtistType.values());
        model.addAttribute("genres", Genre.values());
        return "form-artist.html";
    }

    @GetMapping("/artists/{id}/edit")
    public String showEdit(@PathVariable Long id, Model model){
        Artist artist = this.artistService.findById(id).orElseThrow(() -> new ArtistNotFoundException(id));
        List<Album> albumList = this.albumService.listAll();
        model.addAttribute("artist", artist);
        model.addAttribute("types", ArtistType.values());
        model.addAttribute("genres", Genre.values());
        model.addAttribute("albums", albumList);
        return "form-artist.html";

    }

    @PostMapping("/artists/")
    public String save(@RequestParam String name,
                       @RequestParam ArtistType artistType,
                       @RequestParam Genre genre,
                       @RequestParam Long albumId){
        this.artistService.save(name, artistType, genre, albumId);
        return "redirect:/artists";
    }

    @PostMapping("/artists/{id}")
    public String edit(@PathVariable Long id,
                       @RequestParam String name,
                       @RequestParam ArtistType artistType,
                       @RequestParam Genre genre,
                       @RequestParam Long albumId){
        this.artistService.edit(id, name, artistType, genre, albumId);
        return "redirect:/artists";
    }

    @PostMapping("/artists/{id}/delete")
    public String delete(@PathVariable Long id) {
        this.artistService.deleteById(id);
        return "redirect:/artists";
    }

}
