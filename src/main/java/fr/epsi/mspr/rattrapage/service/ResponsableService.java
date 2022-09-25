package fr.epsi.mspr.rattrapage.service;

import fr.epsi.mspr.rattrapage.beans.Etudiant;
import fr.epsi.mspr.rattrapage.beans.Responsable;
import fr.epsi.mspr.rattrapage.interfacee.ResponsableInterface;
import fr.epsi.mspr.rattrapage.repository.ResponsableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResponsableService implements ResponsableInterface {

    @Autowired
    private final ResponsableRepository responsableRepository;

    public ResponsableService(ResponsableRepository responsableRepository) {
        this.responsableRepository = responsableRepository;
    }

    @Override
    public List<Responsable> getResponsable() {

        System.out.println("-----------------------Get responsable------------------------");
        System.out.println(responsableRepository.findAll());
        return responsableRepository.findAll();
    }

    @Override
    public void addResponsable(Responsable responsable) {

        responsableRepository.save(responsable);

    }

    @Override
    public Responsable updateResponsable(int id, Responsable responsable) {

        return responsableRepository.findById(id)
                .map(p->{
                    p.setNom(responsable.getNom());
                    p.setPrenom(responsable.getPrenom());
                    p.setLogin(responsable.getLogin());
                    p.setDate_naissance(responsable.getDate_naissance());
                    p.setPassword(responsable.getPassword());
                    p.setEmail(responsable.getEmail());
                    p.setTelephone(responsable.getTelephone());
                    p.setAdresse(responsable.getAdresse());
                    return responsableRepository.save(responsable);
                }).orElseThrow(() -> new RuntimeException("Responsable pedagogique n'on trouver"));
    }

    @Override
    public void dropResponsable(int id_responsable) {
        Responsable responsable = responsableRepository.findById(id_responsable).orElseThrow(() -> new RuntimeException("Responsable non trouver"));

        if(responsable != null)
            responsableRepository.delete(responsable);
    }
}
