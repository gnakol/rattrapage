package fr.epsi.mspr.rattrapage.repository;

import fr.epsi.mspr.rattrapage.beans.Intervenant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IntervenantRepository extends JpaRepository<Intervenant, Integer> {

}
