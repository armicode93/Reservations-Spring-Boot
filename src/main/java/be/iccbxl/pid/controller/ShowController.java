package be.iccbxl.pid.controller;

import be.iccbxl.pid.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Controller
public class ShowController {
    @Autowired
    ShowService service;

    @GetMapping("/shows")
    public String index2(Model model)
    {
        List<Show> shows = service.getAll();

        model.addAttribute("shows",shows);
        model.addAttribute("title","Liste des spectacles");

        return "show/index";
    }

    @GetMapping("/shows/{id}")
    public String show(Model model, @PathVariable("id") String id)
    {
        Show show = service.get(id);

    //Récupérer les artistes du spectacle et les grouper par type
        Map<String,ArrayList<Artist>> collaborateurs = new TreeMap<>();

        for(ArtistType at : show.getArtistTypes()) {
            if(collaborateurs.get(at.getType().getType()) == null) {
            	collaborateurs.put(at.getType().getType(), new ArrayList<>());
            }

            collaborateurs.get(at.getType().getType()).add(at.getArtist());
        }
        model.addAttribute("collaborateurs", collaborateurs);



        model.addAttribute("show",show);
        model.addAttribute("title","Fiche d'un show");

        return "show/show";
    }
}
