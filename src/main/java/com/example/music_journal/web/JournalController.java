package com.example.music_journal.web;

//import com.example.music_journal.model.Album;
//import com.example.music_journal.model.Artist;
//import com.example.music_journal.model.enumerations.ArtistType;
//import com.example.music_journal.model.enumerations.Genre;
import com.example.music_journal.service.AlbumService;
import com.example.music_journal.service.ArtistService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;

//import java.util.List;
//import java.util.Optional;

@Controller
public class JournalController{

    private final ArtistService artistService;
    private final AlbumService albumService;

    public JournalController(ArtistService artistService, AlbumService albumService) {
        this.artistService = artistService;
        this.albumService = albumService;
    }

    //GET -> /journal
    @GetMapping("/journal")
    public String showJournal(Model model) {
        return "";
    }
//
//    //GET -> /api/artists
//    @GetMapping("/artists")
//    public String getArtists(Model model){
//        return "artists";
//    }
//
//    //GET -> /api/artists/add
//    @GetMapping("/artists/add")
//    public String getForm(Model model){
//        List<Album> albumList = this.albumService.listAll();
//        model.addAttribute("types",ArtistType.values());
//        model.addAttribute("genres", Genre.values());
//        model.addAttribute("albums", albumList);
//        return "form-artist";
//    }
//
//
////    @GetMapping("/artists/{id}/edit")
////    public String getEdit(@PathVariable Long id, Model model){
////        List<Album> albumList = this.albumService.listAll();
////        //Optional<Artist> artist = this.artistService.findById(id);
////        //artist.ifPresent(a -> model.addAttribute("artist", a));
////        model.addAttribute("types", ArtistType.values());
////        model.addAttribute("genres", Genre.values());
////        model.addAttribute("albums", albumList);
////        return "form-artist";
////    }
////
////    @PostMapping("/artists")
////    public String postSave(@ModelAttribute Artist artist){
////        this.artistService.save(artist);
////        return "redirect:/artists";
////    }
////
////    @PostMapping("/artists/{id}/edit")
////    public String postEdit(@PathVariable Long id, @RequestParam String name,
////                           @RequestParam ArtistType artistType,
////                           @RequestParam String genre,
////                           @RequestParam Long albumId){
////        Album album = this.albumService.findById(albumId).get();
////        Genre genreEnum = Genre.valueOf(genre);
////        this.artistService.edit(id, name, artistType, genreEnum, albumId);
////        return "redirect:/artists";
////    }
////
////    @RequestMapping(value = "/artists/delete/{id}", method = RequestMethod.DELETE)
////    public String deleteArtist(@PathVariable Long id) {
////        Optional<Artist> optionalArtist = artistService.findById(id);
////        if (optionalArtist.isPresent()) {
////            artistService.deleteById(id);
////        }
////        return "redirect:/artists";
////    }
//
//
//    @GetMapping("/artists/{id}/delete")
//    public String deleteArtist(@PathVariable Long id) {
//        this.artistService.deleteById(id);
//        return "redirect:/artists";
//    }
//
//
//    @GetMapping("/albums/{id}/delete")
//    public String deleteAlbum(@PathVariable Long id) {
//        this.albumService.deleteById(id);
//        return "redirect:/albums";
//    }
//
//
////    @PostMapping("/artists")
////    public String saveOrUpdateArtist(@ModelAttribute Artist artist, @RequestParam(required = false) Long albumId) {
////        if (albumId != null) {
////            Album album = albumService.findById(albumId).orElse(null);
////            artist.getAlbums().add(album);
////        }
////
////        if (artist.getId() == null) {
////            this.artistService.save(artist);
////        } else {
////            this.artistService.edit(artist.getId(), artist.getName(), artist.getArtistType(), artist.getGenre(), albumId);
////        }
////
////        return "redirect:/artists";
////    }
////
////
////    @GetMapping("/artists/{id}")
////    public String getEdit(@PathVariable Long id, Model model) {
////        List<Album> albumList = this.albumService.listAll();
////        Optional<Artist> artist = this.artistService.findById(id);
////        artist.ifPresent(a -> model.addAttribute("artist", a));
////        model.addAttribute("types", ArtistType.values());
////        model.addAttribute("genres", Genre.values());
////        model.addAttribute("albums", albumList);
////        return "form-artist";
////    }
////
////    @PostMapping("/artists/{id}")
////    public String postEdit(@PathVariable Long id, @ModelAttribute Artist artist, @RequestParam(required = false) Long albumId) {
////        artist.setId(id);
////        this.artistService.edit(artist.getId(), artist.getName(), artist.getArtistType(), artist.getGenre(), albumId);
////        return "redirect:/artists";
////    }
////
//
//
}
