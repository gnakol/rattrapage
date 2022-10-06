package fr.epsi.mspr.rattrapage.repository;

import fr.epsi.mspr.rattrapage.beans.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailRattrapageRepository extends JpaRepository<DetailRattrapage, KeyDetail> {

    public List<DetailRattrapage> findByRattrapage(Rattrapage rattrapage);

}
