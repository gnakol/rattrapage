package fr.epsi.mspr.rattrapage.controllers;

import fr.epsi.mspr.rattrapage.beans.Matiere;
import fr.epsi.mspr.rattrapage.service.ModuleService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/module")
public class ModuleController {

    private final ModuleService moduleService;

    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @GetMapping("/liste")
    public List<Matiere> listeModule()
    {
        return moduleService.listeMatiere();
    }

    @PostMapping("/ajouter")
    public String ajouterModule(@Validated @RequestBody Matiere matiere)
    {
        moduleService.ajouterMatiere(matiere);
        return "Module ajoutr avec succes";
    }

    @PutMapping("/{code_module}/update")
    public String updateModule(@Validated @PathVariable int code_module, @RequestBody Matiere matiere)
    {
        matiere = moduleService.updateMatiere(code_module, matiere);
        return "Mise à jour de la matiere effectuer avec succes";
    }

    @DeleteMapping("/{code_module}/remove")
    public String removeModule(@Validated @PathVariable int code_module)
    {
        moduleService.removeMatiere(code_module);
        return "La suppression du module à été une reussite";
    }

    @GetMapping("/{code_module}/searchById")
    public Matiere searchByIdModule(@Validated @PathVariable int code_module)
    {
        return moduleService.searchByIdModule(code_module);
    }


}
