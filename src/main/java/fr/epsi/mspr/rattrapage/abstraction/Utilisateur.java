package fr.epsi.mspr.rattrapage.abstraction;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "personne")
@NoArgsConstructor
abstract public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_utilisateur;

    @Column(name="nom")
    private String nom;

    @Column(name="prenom")
    private String prenom;

    @Column(name = "userName")
    private String login;

    @Column(name = "dateNaissance")
    private Date date_naissance;

    @Column(name = "motDePasse")
    private String password;

    @Column(name = "mail")
    private String email;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "fonction")
    private String role;



}
