package fr.epsi.mspr.rattrapage.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.epsi.mspr.rattrapage.interfacee.DetailRattrapageInterface;
import fr.epsi.mspr.rattrapage.service.DetailRattrapageService;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "detail_rattrapage")
public class DetailRattrapage {

    @EmbeddedId
    private KeyDetail id_detail;

    @ManyToOne()
    @MapsId("id_etudiant")
    @JoinColumn(name = "id_etudiant")
    @JsonIgnoreProperties({"liste_detail"})
    private Etudiant etudiant;

    @ManyToOne
    @MapsId("reference_rattrapage")
    @JoinColumn(name = "reference_rattrapage")
    @JsonIgnoreProperties({"responsable, intervenant, surveillant, module, classe, liste_detail"})
    private Rattrapage rattrapage;

    @Column(name = "note")
    private float note;

    @Column(name = "heure_sortie_epreuve")
    private int heur_sortie_etudiant;

    @Column(name = "presence_etudiant")
    private int presence_etudiant;



}
