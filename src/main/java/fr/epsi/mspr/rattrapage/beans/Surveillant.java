package fr.epsi.mspr.rattrapage.beans;

import fr.epsi.mspr.rattrapage.abstraction.Utilisateur;
import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "surveillant")
public class Surveillant{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_surveillant;

    @Column(name="nom")
    private String nom;

    @Column(name="prenom")
    private String prenom;

    @Column(name = "login_surveillant")
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
