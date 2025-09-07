package edu.unimag.taller01.servicies;

import edu.unimag.taller01.entities.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {


    Vehicle createVehicle(Vehicle vehicle);
    Vehicle updateVehicle(Long id, Vehicle vehicle);
    Optional<Vehicle> findByPlate(String plate);
    List<Vehicle> findAll();
    void deleteVehicle(Long id);
    Optional<Vehicle> findById(Long id);
}
