package fr.epsi.mspr.rattrapage.controllers;

import fr.epsi.mspr.rattrapage.beans.DetailRattrapage;
import fr.epsi.mspr.rattrapage.beans.Etudiant;
import fr.epsi.mspr.rattrapage.beans.KeyDetail;
import fr.epsi.mspr.rattrapage.beans.Rattrapage;
import fr.epsi.mspr.rattrapage.service.DetailRattrapageService;
import org.springframework.security.core.parameters.P;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping("/detail")
public class DetailRattrapageController {

    private final DetailRattrapageService detailRattrapageService;

    public DetailRattrapageController(DetailRattrapageService detailRattrapageService) {
        this.detailRattrapageService = detailRattrapageService;
    }

    @GetMapping("/liste")
    public LinkedList<DetailRattrapage> listeDetail()
    {
        return detailRattrapageService.listeDetail();
    }

    @PostMapping("/ajouter")
    public String ajouterDetail(@Validated @RequestBody DetailRattrapage detailRattrapage)
    {
        detailRattrapageService.ajouterDetail(detailRattrapage);
        return "ajout du detail avec succes";
    }

    @PutMapping("/{id_etudiant}/{code_rattrapage}/update")
    private String updateDetail(@Validated @PathVariable int id_etudiant, @PathVariable int code_rattrapage, @RequestBody DetailRattrapage detailRattrapage)
    {
        KeyDetail keyDetail = new KeyDetail(id_etudiant, code_rattrapage);
        detailRattrapage = detailRattrapageService.updateDetail(keyDetail, detailRattrapage);
        return "String mise à jour du detail effectuer avec succes";
    }

    @DeleteMapping("/{id_etudiant}/{code_rattrapage}/remove")
    private String removeDetail(@Validated @PathVariable  int id_etudiant, @PathVariable int code_rattrapage)
    {
        detailRattrapageService.removeDetail(id_etudiant, code_rattrapage);
        return  "La suppression de ce detail est un success";
    }

    // Trouver un detail retrappage(inscription ou convocation ) grace à l'ID

    @GetMapping("/{id_etudiant}/{code_rattrapage}/searchById")
    private DetailRattrapage searchByIdDetail(@Validated @PathVariable int id_etudiant, @PathVariable int code_rattrapage)
    {
        return detailRattrapageService.searchByIdDetail(id_etudiant, code_rattrapage);
    }

    // Liste des etudiants par rattrapage

    @GetMapping("/{code_rattrapage}/listeEtudiantRattrapage")
    public List<Etudiant> listeEtudiantRattrapage(@Validated @PathVariable int code_rattrapage)
    {
        return detailRattrapageService.listeEtudiantRattrapage(code_rattrapage);
    }

    // modifier note à etudiant partir d'un rattrapage

    @PutMapping("/{id_etudiant}/{code_rattrapage}/modifierNoteEtudiant")
    public String modifyNoteEtudiant(@Validated @PathVariable int id_etudiant, @PathVariable int code_rattrapage, @RequestBody DetailRattrapage detailRattrapage)
    {
        //System.out.println(detailRattrapage);
        detailRattrapageService.modifyNoteEtudiant(id_etudiant, code_rattrapage, detailRattrapage);
        return "La note de l'etudiant à bien été modifier";
    }

    @GetMapping("/{id_intervenant}/listeDetailIntervenant")
    public List<DetailRattrapage> listeDetailIntervenant(@Validated @PathVariable int id_intervenant)
    {
        return detailRattrapageService.listeDetailIntervenant(id_intervenant);
    }

    @GetMapping("/{id_intervenant}/listeRattrapageDeIntervenant")
    public List<DetailRattrapage> listeRattrapageDeIntervenant(@Validated @PathVariable int id_intervenant)
    {
        return detailRattrapageService.listeRattrapageDeIntervenant(id_intervenant);
    }

    @GetMapping("/{code_rattrapage}/listeDetailParRattra")
    public List<DetailRattrapage> listeDetailParRattra(@Validated @PathVariable int code_rattrapage)
    {
        return detailRattrapageService.listeDetailParRattrapage(code_rattrapage);
    }

    // liste detail des rattrapage par intervenant

    @GetMapping("/{id_intervenant}/listeDetailDesRattrapageIntervenant")
    public List<DetailRattrapage> listeDetailDesRattrapageIntervenant(@Validated @PathVariable int id_intervenant)
    {
        return detailRattrapageService.listeDetailDesRattrapageIntervenant(id_intervenant);
    }

    // liste des etudiants concernant une surveillant

    @GetMapping("/{id_etudiant}/listeEtudiantParSurveillant")
    public List<Etudiant> listeEtudiantParSurveillant(@Validated @PathVariable int id_etudiant)
    {
        return detailRattrapageService.listeEtudiantParSurveillant(id_etudiant);
    }



}
