package fr.epsi.mspr.rattrapage.beans;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;

@Data
@Entity
@Table(name = "rattrapage")
public class Rattrapage {

    /*
    * */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reference_rattrapage;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "code_classe")
    private Parcourt classe;

    @ManyToOne
    @JoinColumn(name = "code_module", nullable = false)
    private Matiere matiere;

    @Column(name = "nombre_eleve")
    private int nombre_etudiant;

    @ManyToOne
    @JoinColumn(name = "id_intervenant",nullable = false)
    private Intervenant intervenant;

    @ManyToOne
    @JoinColumn(name = "id_surveillant", nullable = false)
    private Surveillant surveillant;

    @Column(name = "date_rattrapage")
    private Date date_rattrapage;

    @Column(name = "duree")
    private int duree;

    @Column(name = "salle")
    private String nom_salle;

    @ManyToOne
    @JoinColumn(name = "id_responsable",nullable = false)
    private Responsable responsable;







}
