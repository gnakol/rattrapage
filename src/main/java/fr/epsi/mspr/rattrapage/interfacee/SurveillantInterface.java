package fr.epsi.mspr.rattrapage.interfacee;

import fr.epsi.mspr.rattrapage.beans.Responsable;
import fr.epsi.mspr.rattrapage.beans.Surveillant;

import java.util.List;

public interface SurveillantInterface {

    public List<Surveillant> listeSurveillant();

    public void ajouterSurveillant(Surveillant surveillant);

    public Surveillant updateSurveillant(int id_surveillant, Surveillant surveillant);

    public void removeSurveillant(int id_surveillant);
}
