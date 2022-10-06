package fr.epsi.mspr.rattrapage.beans;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.security.Key;

@Data
@Embeddable

public class KeyDetail implements Serializable {

    @Column(name = "id_etudiant")
    private int etudiant_key;

    @Column(name = "reference_rattrapage")
    private int rattrapage_key;

    public KeyDetail()
    {

    }

    public KeyDetail(int etudiant_key, int rattrapage_key){
        this.etudiant_key = etudiant_key;
        this.rattrapage_key = rattrapage_key;
    }

}
