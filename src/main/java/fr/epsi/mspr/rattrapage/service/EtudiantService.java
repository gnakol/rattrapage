package fr.epsi.mspr.rattrapage.service;

import fr.epsi.mspr.rattrapage.beans.Etudiant;
import fr.epsi.mspr.rattrapage.interfacee.EtudiantInterface;
import fr.epsi.mspr.rattrapage.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService implements EtudiantInterface {

    @Autowired
    private final EtudiantRepository etudiantRepository;

    public EtudiantService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }


    @Override
    public List<Etudiant> listeEtudiant() {

        return etudiantRepository.findAll();
    }

    @Override
    public void ajouterEtudiant(Etudiant etudiant) {

        etudiantRepository.save(etudiant);

    }

    @Override
    public Etudiant updateEtudiant(int id_etudiant, Etudiant etudiant) {

        return etudiantRepository.findById(id_etudiant)
                .map(p->{
                    p.setNom(etudiant.getNom());
                    p.setPrenom(etudiant.getPrenom());
                    p.setEmail(etudiant.getPrenom());
                    p.setTelephone(etudiant.getTelephone());
                    p.setSexe(etudiant.getSexe());
                    return etudiantRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("desoler etudiant non trouver"));
    }

    @Override
    public void dropEtudiant(int id_etudiant) {

        Etudiant etudiant = etudiantRepository.findById(id_etudiant).orElseThrow(() -> new RuntimeException("etudiant non trouver"));
        if(etudiant != null)
            etudiantRepository.delete(etudiant);
    }
}
