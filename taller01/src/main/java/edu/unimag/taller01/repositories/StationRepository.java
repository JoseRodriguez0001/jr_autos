package edu.unimag.taller01.repositories;

import edu.unimag.taller01.entities.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface StationRepository  extends JpaRepository<Station, Long>, JpaSpecificationExecutor<Station> {

    Optional<Station> findByAdress(String adress);
}
