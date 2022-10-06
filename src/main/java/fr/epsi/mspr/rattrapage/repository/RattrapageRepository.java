package fr.epsi.mspr.rattrapage.repository;

import fr.epsi.mspr.rattrapage.beans.Intervenant;
import fr.epsi.mspr.rattrapage.beans.Rattrapage;
import fr.epsi.mspr.rattrapage.beans.Responsable;
import fr.epsi.mspr.rattrapage.beans.Surveillant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RattrapageRepository extends JpaRepository<Rattrapage, Integer> {

    public List<Rattrapage> findBySurveillant(Surveillant surveillant);

    public List<Rattrapage> findByResponsable(Responsable responsable);

    public List<Rattrapage> findByIntervenant(Intervenant intervenant);

    //public List<Rattrapage> findByEtatIntervenant(Intervenant intervenant);

}
