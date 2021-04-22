package be.iccbxl.pid.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import be.iccbxl.pid.model.Artist;
import be.iccbxl.pid.model.ArtistService;

import be.iccbxl.pid.model.Artist;
import be.iccbxl.pid.model.ArtistService;

@Controller
public class ArtistController {
    @Autowired
    ArtistService service;

    @GetMapping("/artists")
    public String index() {
        List<Artist> artists = service.getAllArtists();

        // erreur : model ??? a resoudre
        /*
        model.addAttribute("artists", artists);
        model.addAttribute("title", "Liste des artistes");
*/
        return "artist/index";
    }

}




