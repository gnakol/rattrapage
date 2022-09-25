package fr.epsi.mspr.rattrapage.service;

import fr.epsi.mspr.rattrapage.beans.Matiere;
import fr.epsi.mspr.rattrapage.interfacee.ModuleInterface;
import fr.epsi.mspr.rattrapage.repository.MatiereRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleService implements ModuleInterface {

    private final MatiereRepository moduleRepository;

    public ModuleService(MatiereRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }

    @Override
    public List<Matiere> listeMatiere() {
        return moduleRepository.findAll();
    }

    @Override
    public void ajouterMatiere(Matiere matiere) {
        moduleRepository.save(matiere);
    }

    @Override
    public Matiere updateMatiere(int code_module, Matiere matiere) {
        return moduleRepository.findById(code_module)
                .map(p->{
                    p.setNom(matiere.getNom());
                    p.setCredit(matiere.getCredit());
                    return moduleRepository.save(p);
                }).orElseThrow(()-> new RuntimeException("Module non trouver"));
    }

    @Override
    public void removeMatiere(int id_module) {
        Matiere matiere = moduleRepository.findById(id_module).orElseThrow(()-> new RuntimeException("impossible de supp module inexistant"));
        if(matiere != null)
            moduleRepository.delete(matiere);
    }

    @Override
    public Matiere searchByIdModule(int code_module) {
        return moduleRepository.findById(code_module).orElseThrow();
    }
}
