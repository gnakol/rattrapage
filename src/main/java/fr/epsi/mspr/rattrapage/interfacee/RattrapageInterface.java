package fr.epsi.mspr.rattrapage.interfacee;

import fr.epsi.mspr.rattrapage.beans.Rattrapage;

import java.util.LinkedList;
import java.util.List;

public interface RattrapageInterface {

    public LinkedList<Rattrapage> listeRattrapage();

    public void ajouterRattrapage(Rattrapage rattrapage);

    public Rattrapage updateRattrapage(int code_rattrapage, Rattrapage rattrapage);

    public void removeRattrapage(int code_rattrapage);

    public Rattrapage searchByIdRattrapage(int code_rattrapage);

    public void addEtudiantToRattrapage(int id_etudiant, int code_rattrapage);

    public  List<Rattrapage> vueSurveillantRattrapage(int id_surveillant);

    public List<Rattrapage> vueResponsableRattrapage(int id_responsable);

    public List<Rattrapage> vueIntervenantRattrapage(int id_intervenant);



}
