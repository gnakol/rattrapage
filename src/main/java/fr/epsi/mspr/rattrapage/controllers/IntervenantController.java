package fr.epsi.mspr.rattrapage.controllers;

import fr.epsi.mspr.rattrapage.beans.Intervenant;
import fr.epsi.mspr.rattrapage.service.IntervenantService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/intervenant")
public class IntervenantController {

    private final IntervenantService intervenantService;

    public IntervenantController(IntervenantService intervenantService) {
        this.intervenantService = intervenantService;
    }

    @GetMapping("/liste")
    public List<Intervenant> listeIntervenant()
    {
        return intervenantService.listeIntervenant();
    }

    @PostMapping("/ajouter")
    public String ajouterIntervenant(@Validated @RequestBody Intervenant intervenant)
    {
        intervenantService.ajouterIntervenant(intervenant);
        return "Intervenant ajouter avec succes";
    }

    @PutMapping("/{id_intervenant}/update")
    public String updateIntervenant(@Validated @PathVariable int id_intervenant, @RequestBody Intervenant intervenant)
    {
        intervenant = intervenantService.updateIntervenant(id_intervenant, intervenant);
        return "Mise à jour de l'intervenant effectuer avec succes";
    }

    @DeleteMapping("/{id_intervenant}/remove")
    public String removeIntervenant(@Validated @PathVariable int id_intervenant)
    {
        intervenantService.removeIntervenant(id_intervenant);
        return "Intervenant supprimer avec succes";
    }

    @GetMapping("/{id_intervenant}/searchById")
    public Intervenant searchById(@Validated @PathVariable int id_intervenant)
    {
        return intervenantService.searchById(id_intervenant);
    }


}
