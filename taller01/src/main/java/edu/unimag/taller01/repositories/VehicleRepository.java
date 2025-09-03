package edu.unimag.taller01.repositories;

import edu.unimag.taller01.entities.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository  extends JpaRepository<Vehicle, Long>, JpaSpecificationExecutor<Vehicle> {

    Optional<Vehicle> findByPlate(String plate);
}
