package fr.epsi.mspr.rattrapage.controllers;

import fr.epsi.mspr.rattrapage.beans.Etudiant;
import fr.epsi.mspr.rattrapage.service.EtudiantService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/etudiant")
public class EtudiantController {

    private final EtudiantService etudiantService;

    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @GetMapping("/liste")
    public List<Etudiant> listeEtudiant()
    {
        return etudiantService.listeEtudiant();
    }

    @PostMapping("ajouter")
    public String ajouterEtudiant(@Validated @RequestBody Etudiant etudiant)
    {
        etudiantService.ajouterEtudiant(etudiant);
        return "Ajouter avec succes";
    }

    @PutMapping("/{id_etudiant}/update")
    public String updateEtudiant(@Validated @PathVariable int id_etudiant, @RequestBody Etudiant etudiant)
    {
        etudiant = etudiantService.updateEtudiant(id_etudiant, etudiant);
        return "Mise à jour effectuer avec succès";
    }

    @DeleteMapping("/{id_etudiant}/remove")
    public String removeEtudiant(@Validated @PathVariable int id_etudiant)
    {
        etudiantService.dropEtudiant(id_etudiant);
        return "Suppression effectuer avec succes";
    }
}
