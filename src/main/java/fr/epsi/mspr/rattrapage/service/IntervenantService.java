package fr.epsi.mspr.rattrapage.service;

import fr.epsi.mspr.rattrapage.beans.Intervenant;
import fr.epsi.mspr.rattrapage.interfacee.IntervenantInterface;
import fr.epsi.mspr.rattrapage.repository.IntervenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntervenantService implements IntervenantInterface {

    @Autowired
    private final IntervenantRepository intervenantRepository;

    public IntervenantService(IntervenantRepository intervenantRepository) {
        this.intervenantRepository = intervenantRepository;
    }

    @Override
    public List<fr.epsi.mspr.rattrapage.beans.Intervenant> listeIntervenant() {
        return intervenantRepository.findAll();
    }

    @Override
    public void ajouterIntervenant(fr.epsi.mspr.rattrapage.beans.Intervenant intervenant) {
        intervenantRepository.save(intervenant);
    }

    @Override
    public fr.epsi.mspr.rattrapage.beans.Intervenant updateIntervenant(int id_intervenant, fr.epsi.mspr.rattrapage.beans.Intervenant intervenant) {
        return intervenantRepository.findById(id_intervenant)
                .map(p->{
                    p.setNom(intervenant.getNom());
                    p.setPrenom(intervenant.getPrenom());
                    p.setLogin(intervenant.getLogin());
                    p.setDate_naissance(intervenant.getDate_naissance());
                    p.setPassword(intervenant.getPassword());
                    p.setEmail(intervenant.getEmail());
                    p.setTelephone(intervenant.getTelephone());
                    p.setAdresse(intervenant.getAdresse());
                    return intervenantRepository.save(p);

                }).orElseThrow(() -> new RuntimeException("Intervenant introuvable"));
    }

    @Override
    public void removeIntervenant(int id_intervenant) {

        fr.epsi.mspr.rattrapage.beans.Intervenant intervenant = intervenantRepository.findById(id_intervenant).orElseThrow(()-> new RuntimeException("Intervenant introuvable"));
        if(intervenant != null)
            intervenantRepository.delete(intervenant);

    }

    @Override
    public Intervenant searchById(int id_intervenant) {

        return intervenantRepository.findById(id_intervenant).orElseThrow();
    }
}
