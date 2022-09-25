package fr.epsi.mspr.rattrapage.interfacee;

import fr.epsi.mspr.rattrapage.beans.Rattrapage;

import java.util.List;

public interface RattrapageInterface {

    public List<Rattrapage> listeRattrapage();

    public void ajouterRattrapage(Rattrapage rattrapage);

    public Rattrapage updateRattrapage(int code_rattrapage, Rattrapage rattrapage);

    public void removeRattrapage(int code_rattrapage);

    public Rattrapage searchByIdRattrapage(int code_rattrapage);

}
