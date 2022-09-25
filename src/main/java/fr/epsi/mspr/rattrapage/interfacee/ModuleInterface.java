package fr.epsi.mspr.rattrapage.interfacee;

import fr.epsi.mspr.rattrapage.beans.Matiere;

import java.util.List;

public interface ModuleInterface {

    public List<Matiere> listeMatiere();


    public void ajouterMatiere(Matiere matiere);

    public Matiere updateMatiere(int code_module, Matiere matiere);

    public void removeMatiere(int id_module);

    public Matiere searchByIdModule(int code_module);
}
