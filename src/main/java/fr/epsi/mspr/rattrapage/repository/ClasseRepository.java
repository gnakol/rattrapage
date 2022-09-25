package fr.epsi.mspr.rattrapage.repository;

import fr.epsi.mspr.rattrapage.beans.Parcourt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClasseRepository extends JpaRepository<Parcourt, Integer> {
}
