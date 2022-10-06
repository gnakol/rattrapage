package fr.epsi.mspr.rattrapage.service;

import fr.epsi.mspr.rattrapage.beans.*;
import fr.epsi.mspr.rattrapage.interfacee.DetailRattrapageInterface;
import fr.epsi.mspr.rattrapage.repository.DetailRattrapageRepository;
import fr.epsi.mspr.rattrapage.repository.EtudiantRepository;
import fr.epsi.mspr.rattrapage.repository.IntervenantRepository;
import fr.epsi.mspr.rattrapage.repository.RattrapageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class DetailRattrapageService implements DetailRattrapageInterface {

    @Autowired
    private final DetailRattrapageRepository detailRattrapageRepository;

    @Autowired
    private final RattrapageService rattrapageService;

    @Autowired
    private final IntervenantRepository intervenantRepository;

    @Autowired
    private final RattrapageRepository rattrapageRepository;

    @Autowired
    private final EtudiantRepository etudiantRepository;

    public DetailRattrapageService(DetailRattrapageRepository detailRattrapageRepository, RattrapageService rattrapageService, IntervenantRepository intervenantRepository, RattrapageRepository rattrapageRepository, EtudiantRepository etudiantRepository) {
        this.detailRattrapageRepository = detailRattrapageRepository;
        this.rattrapageService = rattrapageService;
        this.intervenantRepository = intervenantRepository;
        this.rattrapageRepository = rattrapageRepository;
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public LinkedList<DetailRattrapage> listeDetail() {
        LinkedList<DetailRattrapage> liste_rattapage = new LinkedList<>();

        List<DetailRattrapage> tmp = detailRattrapageRepository.findAll();
        for(int i = 0; i < tmp.size(); i++)
        {
            liste_rattapage.add(tmp.get(i));
        }
        return liste_rattapage;
    }

    @Override
    public void ajouterDetail(DetailRattrapage detailRattrapage) {
        detailRattrapageRepository.save(detailRattrapage);
    }

    @Override
    public DetailRattrapage updateDetail(KeyDetail keyDetail, DetailRattrapage detailRattrapage) {
        return detailRattrapageRepository.findById(keyDetail)
                .map(p->{
                    p.setNote(detailRattrapage.getNote());
                    p.setHeur_sortie_etudiant(detailRattrapage.getHeur_sortie_etudiant());
                    p.setPresence_etudiant(detailRattrapage.getPresence_etudiant());
                    return detailRattrapageRepository.save(p);
                }).orElseThrow(() ->new RuntimeException("attention une exception sur la mise à jour"));
    }

    @Override
    public void removeDetail(int id_etudiant, int code_rattrapage) {

        KeyDetail keyDetail = new KeyDetail(id_etudiant, code_rattrapage);

        DetailRattrapage detailRattrapage = detailRattrapageRepository.findById(keyDetail).orElseThrow();

        if(detailRattrapage != null)
            detailRattrapageRepository.delete(detailRattrapage);
    }

    // Trouver un detail retrappage(inscription ou convocation ) grace à l'ID

    @Override
    public DetailRattrapage searchByIdDetail(int id_etudiant, int code_rattrapage) {

        KeyDetail keyDetail = new KeyDetail(id_etudiant, code_rattrapage);

        return detailRattrapageRepository.findById(keyDetail).orElseThrow(()-> new RuntimeException("il n'existe pas"));
    }

    // Liste des etudiants par rattrapage

    @Override
    public List<Etudiant> listeEtudiantRattrapage(int code_rattrapage) {

        List<Etudiant> liste_etudiant = new LinkedList<>();

        List<DetailRattrapage> details = detailRattrapageRepository.findAll();

        for(int i = 0; i < details.size(); i++)
        {
            if(details.get(i).getId_detail().getRattrapage_key() == code_rattrapage)
                liste_etudiant.add(details.get(i).getEtudiant());
        }

        return liste_etudiant;
    }

    // modifier note à etudiant partir d'un rattrapage
    @Override
    public DetailRattrapage modifyNoteEtudiant(int id_etudiant, int code_rattrapage, DetailRattrapage detailRattrapage) {

        KeyDetail keyDetail = new KeyDetail(id_etudiant, code_rattrapage);

        DetailRattrapage dr = detailRattrapageRepository.findById(keyDetail).orElseThrow();

        dr.setNote(detailRattrapage.getNote());

        return detailRattrapageRepository.save(dr);
    }

    @Override
    public List<DetailRattrapage> listeDetailIntervenant(int id_intervenant)
    {
        return null;
    }

    public List<DetailRattrapage> listeRattrapageDeIntervenant(int id_intervenant)
    {

        List<DetailRattrapage> detailRattrapages = detailRattrapageRepository.findAll();

        List<Rattrapage> liste_rattrapage = rattrapageService.vueIntervenantRattrapage(id_intervenant);

        List<DetailRattrapage> detailFinal = new ArrayList<>();

        for(int i = 0; i < liste_rattrapage.size(); i++)
        {
            if(detailRattrapages.get(i).getRattrapage() == liste_rattrapage.get(i));
            {
                detailFinal.add(detailRattrapages.get(i));
            }
        }

        return detailFinal;
    }

    /* *********************liste detail par rattrapage********************************* */
    public List<DetailRattrapage> listeDetailParRattrapage(int code_rattrapage)
    {
        Rattrapage rattrapage = rattrapageRepository.findById(code_rattrapage).orElseThrow();

        return  detailRattrapageRepository.findByRattrapage(rattrapage);
    }

    // liste detail des rattrapage par intervenant

    public List<DetailRattrapage> listeDetailDesRattrapageIntervenant(int id_intervenant)
    {
        List<Rattrapage> liste_rattrapage_intervenant = rattrapageService.vueIntervenantRattrapage(id_intervenant);
        List<DetailRattrapage> liste_detail_intervenant = new ArrayList<>();

        for (Rattrapage r: liste_rattrapage_intervenant) {
            List<DetailRattrapage> dr = detailRattrapageRepository.findByRattrapage(r);
            for(DetailRattrapage ddr: dr){
                liste_detail_intervenant.add(ddr);
            }
        }

        return liste_detail_intervenant;
    }

    // liste des etudiants concernant une surveillant

    public List<Etudiant> listeEtudiantParSurveillant(int id_surveillant)
    {
        List<Rattrapage> liste_rattrapage_surveillant = rattrapageService.vueSurveillantRattrapage(id_surveillant);

        List<DetailRattrapage> liste_detail_surveillant = new ArrayList<>();

        List<Etudiant> etudiants_surveillant = new ArrayList<>();

        for (Rattrapage r: liste_rattrapage_surveillant)
        {
            List<DetailRattrapage> dr = detailRattrapageRepository.findByRattrapage(r);
            for (DetailRattrapage ddr: dr)
            {
                liste_detail_surveillant.add(ddr);
            }
        }

        List<Etudiant> liste_etudiant = etudiantRepository.findAll();

        for (int i = 0; i < liste_detail_surveillant.size(); i++)
        {
            if(liste_detail_surveillant.get(i).getId_detail().getEtudiant_key() == liste_etudiant.get(i).getId_etudiant())

                etudiants_surveillant.add(liste_etudiant.get(i));
        }

        return  etudiants_surveillant;
    }


}
