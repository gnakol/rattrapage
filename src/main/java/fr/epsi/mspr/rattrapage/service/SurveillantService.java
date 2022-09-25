package fr.epsi.mspr.rattrapage.service;

import fr.epsi.mspr.rattrapage.beans.Surveillant;
import fr.epsi.mspr.rattrapage.interfacee.SurveillantInterface;
import fr.epsi.mspr.rattrapage.repository.SurveillantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SurveillantService implements SurveillantInterface {

    @Autowired
    private final SurveillantRepository surveillantRepository;

    public SurveillantService(SurveillantRepository surveillantRepository) {
        this.surveillantRepository = surveillantRepository;
    }

    @Override
    public List<Surveillant> listeSurveillant() {
        return surveillantRepository.findAll();
    }

    @Override
    public void ajouterSurveillant(Surveillant surveillant) {

        surveillantRepository.save(surveillant);

    }

    @Override
    public Surveillant updateSurveillant(int id_surveillant, Surveillant surveillant) {
        return surveillantRepository.findById(id_surveillant)
                .map(p ->{
                    p.setNom(surveillant.getNom());
                    p.setPrenom(surveillant.getPrenom());
                    p.setLogin(surveillant.getLogin());
                    p.setDate_naissance(surveillant.getDate_naissance());
                    p.setPassword(surveillant.getPassword());
                    p.setEmail(surveillant.getEmail());
                    p.setTelephone(surveillant.getTelephone());
                    p.setAdresse(surveillant.getAdresse());
                    return surveillantRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Attention surveillant introuvable"));
    }

    @Override
    public void removeSurveillant(int id_surveillant) {
        Surveillant surveillant = surveillantRepository.findById(id_surveillant).orElseThrow(() -> new RuntimeException("Surveillant introuvable"));
        if(surveillant != null)
            surveillantRepository.delete(surveillant);
    }
}
