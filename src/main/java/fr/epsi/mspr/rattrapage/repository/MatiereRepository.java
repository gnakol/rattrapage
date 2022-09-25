package fr.epsi.mspr.rattrapage.repository;

import fr.epsi.mspr.rattrapage.beans.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatiereRepository extends JpaRepository<Matiere, Integer> {

}
