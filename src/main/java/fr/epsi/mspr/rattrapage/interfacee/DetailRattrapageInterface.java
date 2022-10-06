package fr.epsi.mspr.rattrapage.interfacee;

import fr.epsi.mspr.rattrapage.beans.DetailRattrapage;
import fr.epsi.mspr.rattrapage.beans.Etudiant;
import fr.epsi.mspr.rattrapage.beans.KeyDetail;

import java.util.LinkedList;
import java.util.List;

public interface DetailRattrapageInterface {

    public LinkedList<DetailRattrapage> listeDetail();

    public  void ajouterDetail(DetailRattrapage detailRattrapage);

    public DetailRattrapage updateDetail(KeyDetail keyDetail, DetailRattrapage detailRattrapage);

    public  void removeDetail(int id_etudiant, int code_etudiant);

    public DetailRattrapage searchByIdDetail(int id_etudiant, int code_rattrapage);

    public List<Etudiant> listeEtudiantRattrapage(int code_rattrapage);

    public DetailRattrapage modifyNoteEtudiant(int id_etudiant, int code_rattrapage, DetailRattrapage detailRattrapage);

    public List<DetailRattrapage> listeDetailIntervenant(int id_intervenant);



}
