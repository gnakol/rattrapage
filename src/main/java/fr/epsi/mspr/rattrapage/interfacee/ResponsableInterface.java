package fr.epsi.mspr.rattrapage.interfacee;

import fr.epsi.mspr.rattrapage.beans.Etudiant;
import fr.epsi.mspr.rattrapage.beans.Responsable;

import java.util.List;

public interface ResponsableInterface {

    public List<Responsable> getResponsable();

    public void addResponsable(Responsable responsable);

    public Responsable updateResponsable(int id, Responsable responsable);

    public void dropResponsable(int id_responsable);
}
