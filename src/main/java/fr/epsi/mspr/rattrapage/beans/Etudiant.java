package fr.epsi.mspr.rattrapage.beans;

import lombok.*;

import javax.persistence.*;

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
}
