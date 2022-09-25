package fr.epsi.mspr.rattrapage.interfacee;

import fr.epsi.mspr.rattrapage.beans.Intervenant;
import fr.epsi.mspr.rattrapage.beans.Responsable;

import java.util.List;

public interface IntervenantInterface {

    public List<Intervenant> listeIntervenant();

    public void ajouterIntervenant(Intervenant intervenant);

    public Intervenant updateIntervenant(int id_intervenant, Intervenant intervenant);

    public void removeIntervenant(int id_intervenant);

    public Intervenant searchById(int id_intervenant);
}
