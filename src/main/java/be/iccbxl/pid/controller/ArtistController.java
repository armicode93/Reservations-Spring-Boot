package be.iccbxl.pid.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import be.iccbxl.pid.model.Artist;
import be.iccbxl.pid.model.ArtistService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class ArtistController {
    @Autowired
    ArtistService service;

    @GetMapping("/artists")
    public String index(Model model) {
        List<Artist> artists = service.getAllArtists();

        model.addAttribute("artists", artists); //model et attribut
        model.addAttribute("title", "Liste des artistes");

        return "artist/index";
    }

    @GetMapping("/artists/{id}") //methode show pour recuperer un artiste avec son id e affiche dans show.html

    public String show(Model model, @PathVariable("id") String id){ // path sert pour faire correspondre l'id de l'url avec celui de la methode show
        Artist artist = service.getArtist(id);
        //get artist est utilie pour recuperer l'artiste dont l-id correspond,

        //nous l'ajoutons au modele avant de renvoyer le template show.html
        model.addAttribute("artist",artist);
        model.addAttribute("title", "Fiche d'un artiste");

        return "artist/show";
    }

}




