package edu.unimag.taller01.servicies;

import edu.unimag.taller01.entities.DriverLicense;
import edu.unimag.taller01.repositories.DriverLicenseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

public interface DriverLicenseService {
    DriverLicense guardar(DriverLicense driverLicense);
    Optional<DriverLicense> findByLicenseNumber( String licenseNumber);
    Optional<DriverLicense> findById( Long id);
    List<DriverLicense> findAll();
    void deleteById( Long id);
    DriverLicense updateDriverLicense(Long id,DriverLicense driverLicense);

}
