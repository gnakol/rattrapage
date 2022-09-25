package fr.epsi.mspr.rattrapage.repository;

import fr.epsi.mspr.rattrapage.beans.Rattrapage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

@Repository
public interface RattrapageRepository extends JpaRepository<Rattrapage, Integer> {

}
