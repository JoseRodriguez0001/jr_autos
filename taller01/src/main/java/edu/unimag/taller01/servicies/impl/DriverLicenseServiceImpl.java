package edu.unimag.taller01.servicies.impl;

import edu.unimag.taller01.entities.DriverLicense;
import edu.unimag.taller01.repositories.DriverLicenseRepository;
import edu.unimag.taller01.repositories.UserRepository;
import edu.unimag.taller01.servicies.DriverLicenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class DriverLicenseServiceImpl implements DriverLicenseService {

    private final DriverLicenseRepository driverLicenseRepository;
    private final UserRepository userRepository;


    @Override
    public DriverLicense guardar(DriverLicense driverLicense) {
        return driverLicenseRepository.save(driverLicense);
    }

    @Override
    public Optional<DriverLicense> findByLicenseNumber(String licenseNumber) {
        return driverLicenseRepository.findByLicenseNumber(licenseNumber);
    }

    @Override
    public Optional<DriverLicense> findById(Long id) {
        return driverLicenseRepository.findById(id);
    }

    @Override
    public List<DriverLicense> findAll() {
        return driverLicenseRepository.findAll().stream().toList();
    }

    @Override
    public void deleteById(Long id) {
        if (!driverLicenseRepository.existsById(id)) {
            throw new NoSuchElementException("Driver License not found with ID:  "+ id);

        }
         driverLicenseRepository.deleteById(id);
    }

    @Override
    public DriverLicense updateDriverLicense(Long id, DriverLicense driverLicense) {
        return driverLicenseRepository.findById(id).map(
                driverLicenseInDB ->{
                    driverLicenseInDB.setLicenseNumber(driverLicense.getLicenseNumber());
                    driverLicenseInDB.setCategory(driverLicense.getCategory());
                    driverLicenseInDB.setExpiresAt(driverLicense.getExpiresAt());
                    driverLicenseInDB.setIssuedAt(driverLicense.getIssuedAt());
                    driverLicenseInDB.setUser(driverLicense.getUser());
                    return driverLicenseRepository.save(driverLicenseInDB);

                }).orElseThrow(()-> new NoSuchElementException("Driver license not found with ID:"+ id));

    }


}
