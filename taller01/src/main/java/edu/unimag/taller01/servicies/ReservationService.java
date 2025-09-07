package edu.unimag.taller01.servicies;

import edu.unimag.taller01.entities.DriverLicense;
import edu.unimag.taller01.entities.Reservation;

import java.util.List;
import java.util.Optional;

public interface ReservationService {

    Reservation createReservation(Reservation reservation);
    Optional<Reservation> findById(Long id);
    List<Reservation> findAll();
    void deleteReservation(Long id);
    Reservation  updateReservation(Long id,Reservation reservation);
    Optional<Reservation> finByStatus(String status);

}
