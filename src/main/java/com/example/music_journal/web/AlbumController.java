package com.example.music_journal.web;

import com.example.music_journal.model.Album;
import com.example.music_journal.model.AlbumForm;
import com.example.music_journal.model.enumerations.ArtistType;
import com.example.music_journal.model.enumerations.Genre;
import com.example.music_journal.model.exceptions.AlbumNotFoundException;
import com.example.music_journal.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AlbumController {

    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping("/albums")
    public String findAll(Model model){
        List<Album> albumList = this.albumService.listAll();
        model.addAttribute("types", ArtistType.values());
        model.addAttribute("genres", Genre.values());
        model.addAttribute("albums", albumList);
        return "albums.html";
    }

    @GetMapping("/albums/{id}")
    public String findById(@PathVariable Long id){

        return "";
    }

    @GetMapping("/albums/add")
    public String showAdd(Model model){
        List<Album> albumList = this.albumService.listAll();
        model.addAttribute("albums", albumList);
        model.addAttribute("types", ArtistType.values());
        model.addAttribute("genres", Genre.values());
        return "form-album.html";
    }

    @GetMapping("/albums/{id}/edit")
    public String showEdit(@PathVariable Long id, Model model){
        Album album = this.albumService.findById(id).orElseThrow(() -> new AlbumNotFoundException(id));
        model.addAttribute("album", album);
        model.addAttribute("types", ArtistType.values());
        model.addAttribute("genres", Genre.values());
        return "form-album.html";

    }

    @PostMapping("/albums/")
    public String save(@RequestParam String name,
                       @RequestParam Integer yearRelease,
                       @RequestParam String favouriteSong,
                       @RequestParam Boolean isDeluxe){
        this.albumService.save(name, yearRelease, favouriteSong, isDeluxe);
        return "redirect:/albums";
    }

    @PostMapping("/albums/{id}")
    public String edit(@PathVariable Long id,
                       @RequestParam String name,
                       @RequestParam Integer yearRelease,
                       @RequestParam String favouriteSong,
                       @RequestParam Boolean isDeluxe,
                       @ModelAttribute("albumForm")AlbumForm albumForm){
        albumForm.setDeluxe(isDeluxe);
        this.albumService.edit(id, name, yearRelease, favouriteSong, albumForm.isDeluxe());
        return "redirect:/albums";
    }

    @PostMapping("/albums/{id}/delete")
    public String delete(@PathVariable Long id) {
        this.albumService.deleteById(id);
        return "redirect:/albums";
    }


}
