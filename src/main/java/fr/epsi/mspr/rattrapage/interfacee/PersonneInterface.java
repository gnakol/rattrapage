package fr.epsi.mspr.rattrapage.interfacee;

import fr.epsi.mspr.rattrapage.beans.Personne;

import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface PersonneInterface {
    public List<Personne> showUser();

    public void addUser(Personne personne);

    public Personne updateUser(int id_user, Personne user);

    public void removeUser(int id_user);

    public Personne searchByIdUser(int id_user);


}
