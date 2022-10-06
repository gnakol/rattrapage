package fr.epsi.mspr.rattrapage.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Data
@Entity
@Table(name = "etudiant")
@NoArgsConstructor
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_etudiant;

    @Column(name="nom")
    @NonNull
    private String nom;

    @NonNull
    @Column(name="prenom")
    private String prenom;

    @Column(name="email")
    private String email;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "sexe")
    private String sexe;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Rattrapage> liste_rattrapage = new LinkedList<>();

    @OneToMany(cascade = CascadeType.MERGE)
    @JsonIgnore
    private List<DetailRattrapage> liste_detail;



}
