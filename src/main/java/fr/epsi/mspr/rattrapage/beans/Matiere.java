package fr.epsi.mspr.rattrapage.beans;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "module")
public class Matiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int code_module;

    @Column(name="nom_module")
    private String nom;

    @Column(name="credit")
    private String credit;
}
