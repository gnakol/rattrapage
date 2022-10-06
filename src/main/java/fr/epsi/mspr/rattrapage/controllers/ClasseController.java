package fr.epsi.mspr.rattrapage.controllers;

import fr.epsi.mspr.rattrapage.beans.Parcourt;
import fr.epsi.mspr.rattrapage.service.ClasseService;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/classe")
public class ClasseController {

    private final ClasseService classeService;

    public ClasseController(ClasseService classeService) {
        this.classeService = classeService;
    }

    @GetMapping("/liste")
    public LinkedList<Parcourt> listeClasse()
    {
        System.out.println("*********************le comportement de la liste chez le controlleur******************");
        System.out.println(classeService.listeParcourt());
        return classeService.listeParcourt();
    }

    @PostMapping("/ajouter")
    public String ajouterClasse(@Validated @RequestBody Parcourt parcourt)
    {
        classeService.ajouterParcourt(parcourt);
        return "Classe ajouter avec succes";
    }

    @PutMapping("/{code_classe}/update")
    public String updateClasse(@Validated @PathVariable int code_classe, @RequestBody Parcourt parcourt)
    {
        parcourt = classeService.updateParcourt(code_classe, parcourt);
        return "mise à jour classe effectuer avec succes";
    }

    @DeleteMapping("/{code_classe}/remove")
    public String removeClasse(@Validated @PathVariable int code_classe)
    {
        classeService.removeParcourt(code_classe);
        return "suppression de la classe avec succes";
    }

    @GetMapping("/{code_classe}/searchById")
    public Parcourt searchByIdClasse(@Validated @PathVariable int code_classe)
    {
        return classeService.searchByIdParcourt(code_classe);
    }


}
