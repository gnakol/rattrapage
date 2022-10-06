package fr.epsi.mspr.rattrapage.service;

import fr.epsi.mspr.rattrapage.beans.Parcourt;
import fr.epsi.mspr.rattrapage.interfacee.ClasseInterface;
import fr.epsi.mspr.rattrapage.repository.ClasseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ClasseService implements ClasseInterface {

    @Autowired
    private final ClasseRepository classeRepository;

    public ClasseService(ClasseRepository classeRepository) {
        this.classeRepository = classeRepository;
    }

    @Override
    public LinkedList<Parcourt> listeParcourt() {
        List<Parcourt> tmp_liste = classeRepository.findAll();
        LinkedList<Parcourt> liste_parcour = new LinkedList<>();

        List<Parcourt> tmp = classeRepository.findAll();

        for(int i = 0; i < tmp.size(); i++)
        {
            liste_parcour.add(tmp.get(i));
        }

        return  liste_parcour;
    }

    @Override
    public void ajouterParcourt(Parcourt parcourt) {
        classeRepository.save(parcourt);
    }

    @Override
    public Parcourt updateParcourt(int code_parcour, Parcourt parcourt) {
        return classeRepository.findById(code_parcour)
                .map(p->{
                    p.setNom_parcourt(parcourt.getNom_parcourt());
                    p.setSemestre(parcourt.getSemestre());
                    p.setAnnee(parcourt.getAnnee());
                    p.setDiplome(parcourt.getDiplome());
                    return classeRepository.save(p);
                }).orElseThrow(()-> new RuntimeException("parcours introuvable"));
    }

    @Override
    public void removeParcourt(int code_parcour) {
        Parcourt parcourt = classeRepository.findById(code_parcour).orElseThrow(()-> new RuntimeException("pas de parcours à supprimer"));
        if(parcourt != null)
            classeRepository.delete(parcourt);
    }

    @Override
    public Parcourt searchByIdParcourt(int code_parcours) {
        return classeRepository.findById(code_parcours).orElseThrow(()-> new RuntimeException("introuvable"));
    }
}
