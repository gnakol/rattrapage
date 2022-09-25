package fr.epsi.mspr.rattrapage.controllers;

import fr.epsi.mspr.rattrapage.beans.Responsable;
import fr.epsi.mspr.rattrapage.service.ResponsableService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/responsable")
public class ResponsableController {

    private final ResponsableService responsableService;

    public ResponsableController(ResponsableService responsableService) {
        this.responsableService = responsableService;
    }

    @GetMapping("/get")
    public List<Responsable> listeResponsable()
    {
        return responsableService.getResponsable();
    }

    @PostMapping("/add")
    public String addResponsable(@Validated @RequestBody Responsable responsable)
    {
        responsableService.addResponsable(responsable);
        return "Responsable ajouter avec succes";
    }

    @PutMapping("/{id_responsable}/update")
    public String updateResponsable(@Validated @PathVariable int id_responsable, @RequestBody Responsable responsable)
    {
        responsable = responsableService.updateResponsable(id_responsable, responsable);
        return "Mise à jour effectuer avec succès";
    }

    @DeleteMapping("/{id_responsable}/remove")
    public String removeResponsable(@Validated @PathVariable int id_responsable)
    {
        responsableService.dropResponsable(id_responsable);
        return "Responsable supprimer avec succes";
    }


}
