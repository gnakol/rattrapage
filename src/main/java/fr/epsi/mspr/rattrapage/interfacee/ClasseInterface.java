package fr.epsi.mspr.rattrapage.interfacee;

import fr.epsi.mspr.rattrapage.beans.Parcourt;

import java.util.LinkedList;
import java.util.List;

public interface ClasseInterface {

    public LinkedList<Parcourt> listeParcourt();

    public void ajouterParcourt(Parcourt parcourt);

    public Parcourt updateParcourt(int code_parcour, Parcourt parcourt);

    public void removeParcourt(int code_parcour);

    public Parcourt searchByIdParcourt(int code_parcours);

}
