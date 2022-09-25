package fr.epsi.mspr.rattrapage.service;

import fr.epsi.mspr.rattrapage.beans.Rattrapage;
import fr.epsi.mspr.rattrapage.interfacee.RattrapageInterface;
import fr.epsi.mspr.rattrapage.repository.RattrapageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RattrapageService implements RattrapageInterface {

    @Autowired
    private final RattrapageRepository rattrapageRepository;

    public RattrapageService(RattrapageRepository rattrapageRepository) {
        this.rattrapageRepository = rattrapageRepository;
    }

    @Override
    public List<Rattrapage> listeRattrapage() {
        return rattrapageRepository.findAll();
    }

    @Override
    public void ajouterRattrapage(Rattrapage rattrapage) {
        rattrapageRepository.save(rattrapage);
    }

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
                    p.setDuree(rattrapage.getDuree());
                    p.setNom_salle(rattrapage.getNom_salle());
                    p.setResponsable(rattrapage.getResponsable());
                    return rattrapageRepository.save(rattrapage);
                }).orElseThrow(()-> new RuntimeException("rattrapage inexistant sorry"));
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
}
