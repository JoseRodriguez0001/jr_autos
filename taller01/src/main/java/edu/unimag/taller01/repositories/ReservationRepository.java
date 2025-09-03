package edu.unimag.taller01.repositories;

import edu.unimag.taller01.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface ReservationRepository  extends JpaRepository<Reservation, Long>, JpaSpecificationExecutor<Reservation> {


}
