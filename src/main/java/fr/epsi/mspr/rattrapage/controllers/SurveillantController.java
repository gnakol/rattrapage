package fr.epsi.mspr.rattrapage.controllers;

import fr.epsi.mspr.rattrapage.beans.Surveillant;
import fr.epsi.mspr.rattrapage.service.SurveillantService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/surveillant")
public class SurveillantController {

    private final SurveillantService surveillantService;

    public SurveillantController(SurveillantService surveillantService) {
        this.surveillantService = surveillantService;
    }

    @GetMapping("/liste")
    public List<Surveillant> listeSurveillant()
    {
        return surveillantService.listeSurveillant();
    }

    @PostMapping("/ajouter")
    public String ajouterSurveillant(@Validated @RequestBody Surveillant surveillant)
    {
        surveillantService.ajouterSurveillant(surveillant);
        return "Surveillant ajouter avec succes";
    }

    @PutMapping("/{id_surveillant}/update")
    public String updateSurveillant(@Validated @PathVariable int id_surveillant, @RequestBody Surveillant surveillant)
    {
        surveillant = surveillantService.updateSurveillant(id_surveillant, surveillant);
        return "Mise à jour du surveillant effectuer avec success";
    }

    @DeleteMapping("/{id_surveillant}/remove")
    public  String removeSurveillant(@Validated @PathVariable int id_surveillant)
    {
        surveillantService.removeSurveillant(id_surveillant);
        return "Surveillant supprimer avec succes";
    }


}
