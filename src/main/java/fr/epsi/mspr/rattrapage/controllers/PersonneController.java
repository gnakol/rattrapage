package fr.epsi.mspr.rattrapage.controllers;

import fr.epsi.mspr.rattrapage.beans.Personne;
import fr.epsi.mspr.rattrapage.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class PersonneController {

    @Autowired
    private final PersonneService personneService;

    public PersonneController(PersonneService personneService) {
        this.personneService = personneService;
    }

    @GetMapping("/showUser")
    public List<Personne> listeUser()
    {
        return personneService.showUser();
    }

    @PostMapping("/addUser")
    @CrossOrigin(origins = "http://localhost:4200")
    public String addUser(@RequestBody Personne personne){
        personneService.addUser(personne);
        return "utilisateur ajouter avec succes";
    }
    
    public String GetForm(Model model)
    {
        model.addAttribute("eleve", new Personne());
        return "index";
    }


}
