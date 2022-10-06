package fr.epsi.mspr.rattrapage.beans;

import fr.epsi.mspr.rattrapage.abstraction.Utilisateur;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Data
@Entity
@Table(name = "intervenant")
public class Intervenant{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_intervenant;

    @Column(name="nom")
    private String nom;

    @Column(name="prenom")
    private String prenom;

    @Column(name = "login_intervenant")
    private String login;

    @Column(name = "date_naissance")
    private Date date_naissance;

    @Column(name = "mot_de_passe")
    private String password;

    @Column(name = "e_mail")
    private String email;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "adresse")
    private String adresse;
}
