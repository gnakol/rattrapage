package fr.epsi.mspr.rattrapage.beans;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "classe")
public class Parcourt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code_classe;

    @Column(name = "nom_parcours")
    private String nom_parcourt;

    @Column(name = "semestre")
    private String semestre;

    @Column(name = "annee")
    private Date annee;

    @Column(name = "diplome")
    private String diplome;
}
