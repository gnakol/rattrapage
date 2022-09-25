package fr.epsi.mspr.rattrapage.controllers;

import fr.epsi.mspr.rattrapage.beans.Rattrapage;
import fr.epsi.mspr.rattrapage.service.RattrapageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rattrapage")
public class RattrapageController {

    @Autowired
    private final RattrapageService rattrapageService;

    public RattrapageController(RattrapageService rattrapageService) {
        this.rattrapageService = rattrapageService;
    }

    @GetMapping("/liste")
    public List<Rattrapage> listeRattrapage()
    {
        return rattrapageService.listeRattrapage();
    }

    @PostMapping("/ajouter")
    public String ajouterRattrapage(@Validated @RequestBody Rattrapage rattrapage)
    {
        rattrapageService.ajouterRattrapage(rattrapage);
        return "rattrapage ajouter avec succes";
    }

    @PutMapping("/{code_rattrapage}/update")
    public String updateRattrapage(@Validated @PathVariable int code_rattrapage, @RequestBody Rattrapage rattrapage)
    {
        rattrapage = rattrapageService.updateRattrapage(code_rattrapage, rattrapage);
        return "mises à jour rattrapage effectuer avec succes";
    }

    @DeleteMapping("/{code_rattrapage}/remove")
    public String removeRattrapage(@Validated @PathVariable int code_rattrapage)
    {
        rattrapageService.removeRattrapage(code_rattrapage);
        return "rattrapage effectuer avec succes";
    }

    @GetMapping("/{code_rattrapage}/searchById")
   public Rattrapage searchByIdRattrapage(@Validated @PathVariable int code_rattrapage)
   {
       return rattrapageService.searchByIdRattrapage(code_rattrapage);
   }
}
