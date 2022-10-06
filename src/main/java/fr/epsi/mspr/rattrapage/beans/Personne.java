package fr.epsi.mspr.rattrapage.beans;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "personne")
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_personne;

    @Column(name = "userName")
    private String user_name;

    @Column(name = "motDePasse")
    private String password;

    @Column(name = "e_mail")
    private String e_mail;


}
