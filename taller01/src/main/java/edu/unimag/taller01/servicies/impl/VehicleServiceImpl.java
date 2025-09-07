package edu.unimag.taller01.servicies.impl;

import edu.unimag.taller01.entities.Vehicle;
import edu.unimag.taller01.repositories.VehicleRepository;
import edu.unimag.taller01.servicies.VehicleService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VehicleServiceImpl implements VehicleService {

    VehicleRepository vehicleRepository;

    @Override@Transactional
    public Vehicle createVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override@Transactional
    public Vehicle updateVehicle(Long id, Vehicle vehicle) {
        return vehicleRepository.findById(id).map(
                vehicleInDB ->{
                    vehicleInDB.setBrand(vehicle.getBrand());
                    vehicleInDB.setModel(vehicle.getModel());
                    vehicleInDB.setPlate(vehicle.getPlate());
                    vehicleInDB.setYear(vehicle.getYear());
                    vehicleInDB.setStatus(vehicle.getStatus());
                    vehicleInDB.setReservations(vehicle.getReservations());
                    vehicleInDB.setStation(vehicle.getStation());

                    return vehicleRepository.save(vehicleInDB);

                }).orElseThrow(()-> new NoSuchElementException("Vehicle not found with ID:"+ id));
    }

    @Override
    public Optional<Vehicle> findByPlate(String plate) {
        return vehicleRepository.findByPlate(plate);
    }


    @Override
    public List<Vehicle> findAll() {
        return vehicleRepository.findAll();
    }

    @Override@Transactional
    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }

    @Override
    public Optional<Vehicle> findById(Long id) {
        return vehicleRepository.findById(id);
    }

}
