package fr.epsi.mspr.rattrapage.service;

import fr.epsi.mspr.rattrapage.beans.Intervenant;
import fr.epsi.mspr.rattrapage.beans.Rattrapage;
import fr.epsi.mspr.rattrapage.beans.Responsable;
import fr.epsi.mspr.rattrapage.beans.Surveillant;
import fr.epsi.mspr.rattrapage.interfacee.RattrapageInterface;
import fr.epsi.mspr.rattrapage.repository.IntervenantRepository;
import fr.epsi.mspr.rattrapage.repository.RattrapageRepository;
import fr.epsi.mspr.rattrapage.repository.ResponsableRepository;
import fr.epsi.mspr.rattrapage.repository.SurveillantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class RattrapageService implements RattrapageInterface {

    @Autowired
    private final RattrapageRepository rattrapageRepository;

    @Autowired
    private final SurveillantRepository surveillantRepository;

    @Autowired
    private final ResponsableRepository responsableRepository;

    @Autowired
    private final IntervenantRepository intervenantRepository;

    public RattrapageService(RattrapageRepository rattrapageRepository, SurveillantRepository surveillantRepository, ResponsableRepository responsableRepository, IntervenantRepository intervenantRepository) {
        this.rattrapageRepository = rattrapageRepository;
        this.surveillantRepository = surveillantRepository;
        this.responsableRepository = responsableRepository;
        this.intervenantRepository = intervenantRepository;
    }


    @Override
    public LinkedList<Rattrapage> listeRattrapage() {

        LinkedList<Rattrapage> liste_rattrapage = new LinkedList<>();

        List<Rattrapage> liste = rattrapageRepository.findAll();
        for(int i = 0; i < liste.size(); i++)
        {
            liste_rattrapage.add(liste.get(i));
        }
        return liste_rattrapage;
    }

    @Override
    public void ajouterRattrapage(Rattrapage rattrapage) {
        rattrapageRepository.save(rattrapage);
    }

    /*@Override
    public Rattrapage updateRattrapage(int code_rattrapage, Rattrapage rattrapage) {
        return rattrapageRepository.findById(code_rattrapage)
                .map(p->{
                    p.setClasse(rattrapage.getClasse());
                    p.setMatiere(rattrapage.getMatiere());
                    p.setIntervenant(rattrapage.getIntervenant());
                    p.setSurveillant(rattrapage.getSurveillant());
                    p.setDate_rattrapage(rattrapage.getDate_rattrapage());
                    p.setDuree(rattrapage.getDuree());
                    p.setDuree(rattrapage.getDuree());
                    p.setNom_salle(rattrapage.getNom_salle());
                    p.setResponsable(rattrapage.getResponsable());
                    return rattrapageRepository.save(rattrapage);
                }).orElseThrow(()-> new RuntimeException("rattrapage inexistant sorry"));
    }*/

    @Override
    public Rattrapage updateRattrapage(int code_rattrapage, Rattrapage rattrapage) {
        return rattrapageRepository.findById(code_rattrapage)
                .map(p->{
                    p.setClasse(rattrapage.getClasse());
                    p.setMatiere(rattrapage.getMatiere());
                    p.setNombre_etudiant(rattrapage.getNombre_etudiant());
                    p.setIntervenant(rattrapage.getIntervenant());
                    p.setSurveillant(rattrapage.getSurveillant());
                    p.setDate_rattrapage(rattrapage.getDate_rattrapage());
                    p.setDuree(rattrapage.getDuree());
                    p.setNom_salle(rattrapage.getNom_salle());
                    p.setResponsable(rattrapage.getResponsable());
                    p.setStatus(rattrapage.getStatus());
                    return rattrapageRepository.save(p);
        }).orElseThrow(() ->new RuntimeException("dksjkjdksk"));
    }

    @Override
    public void removeRattrapage(int code_rattrapage) {
        Rattrapage rattrapage = rattrapageRepository.findById(code_rattrapage).orElseThrow(()-> new RuntimeException("id introuvable du rattrapage"));
        if(rattrapage != null)
            rattrapageRepository.delete(rattrapage);
    }

    @Override
    public Rattrapage searchByIdRattrapage(int code_rattrapage) {
        return rattrapageRepository.findById(code_rattrapage).orElseThrow(()-> new RuntimeException("introuvable cet rattrapage"));
    }

    @Override
    public void addEtudiantToRattrapage(int id_etudiant, int code_rattrapage) {

    }

    @Override
    public List<Rattrapage> vueSurveillantRattrapage(int id_surveillant) {

        Surveillant surveillant = surveillantRepository.findById(id_surveillant).orElseThrow();

        return rattrapageRepository.findBySurveillant(surveillant);


    }

    @Override
    public List<Rattrapage> vueResponsableRattrapage(int id_responsable) {

        Responsable responsable = responsableRepository.findById(id_responsable).orElseThrow();

        return rattrapageRepository.findByResponsable(responsable);
    }

    @Override
    public List<Rattrapage> vueIntervenantRattrapage(int id_intervenant) {

        Intervenant intervenant = intervenantRepository.findById(id_intervenant).orElseThrow();
        return rattrapageRepository.findByIntervenant(intervenant);
    }
}
