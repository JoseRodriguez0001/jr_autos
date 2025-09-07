package edu.unimag.taller01.servicies.impl;

import edu.unimag.taller01.entities.Reservation;
import edu.unimag.taller01.repositories.ReservationRepository;
import edu.unimag.taller01.servicies.ReservationService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    ReservationRepository reservationRepository;

    @Override @Transactional
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    @Override
    public Optional<Reservation> findById(Long id) {
        return reservationRepository.findById(id);
    }

    @Override
    public List<Reservation> findAll() {
        return reservationRepository.findAll();
    }

    @Override @Transactional
    public void deleteReservation(Long id) {
        reservationRepository.deleteById(id);
    }

    @Override @Transactional
    public Reservation updateReservation(Long id, Reservation reservation) {
        return reservationRepository.findById(id).map(
                reservationInDB ->{
                    reservationInDB.setStatus(reservation.getStatus());
                    reservationInDB.setPickupAt(reservation.getPickupAt());
                    reservationInDB.setReturnAt(reservation.getReturnAt());
                    reservationInDB.setTotal_price(reservation.getTotal_price());
                    reservationInDB.setUser(reservation.getUser());
                    reservationInDB.setVehicle(reservation.getVehicle());
                    return reservationRepository.save(reservationInDB);

                }).orElseThrow(()-> new NoSuchElementException("Reservation not found with ID:"+ id));

    }

    @Override
    public Optional<Reservation> finByStatus(String status) {
        return Optional.empty();
    }
}
