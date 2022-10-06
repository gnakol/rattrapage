package fr.epsi.mspr.rattrapage.interfacee;

import fr.epsi.mspr.rattrapage.beans.Etudiant;

import java.util.List;

public interface EtudiantInterface {

    public List<Etudiant> listeEtudiant();
    public void ajouterEtudiant(Etudiant etudiant);
    public Etudiant updateEtudiant(int id, Etudiant etudiant);
    public void dropEtudiant(int id_etudiant);

    public Etudiant searchByIdEtudiant(int id_etudiant);

}
