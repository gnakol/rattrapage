package fr.epsi.mspr.rattrapage.controllers;

import fr.epsi.mspr.rattrapage.beans.Etudiant;
import fr.epsi.mspr.rattrapage.service.EtudiantService;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
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

    @PostMapping("/ajouter")
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

    @GetMapping("/{id_etudiant}/searchById")
    public Etudiant searchByIdEtudiant(@Validated @PathVariable int id_etudiant)
    {
        return etudiantService.searchByIdEtudiant(id_etudiant);
    }

    public String listeHomeEtudiant(Model model)
    {
        List<Etudiant> liste_etudiant = new LinkedList<>();

        List<Etudiant> liste = etudiantService.listeEtudiant();

        for (int i = 0; i< liste.size(); i++)
        {
            liste_etudiant.add(liste.get(i));
        }

        model.addAttribute("liste_etudiant", liste_etudiant);

        return "listeHomeEtudiant";

    }

    @GetMapping("/home")
    public String home()
    {
        return "login";
    }


}
