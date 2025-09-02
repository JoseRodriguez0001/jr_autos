package edu.unimag.taller01.repositorios;

import edu.unimag.taller01.modelos.Reservation;
import edu.unimag.taller01.modelos.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface ReservationRepository  extends JpaRepository<Reservation, Long>, JpaSpecificationExecutor<Reservation> {


}
