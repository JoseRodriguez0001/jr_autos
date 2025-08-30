package edu.unimag.taller01.repositorios;

import edu.unimag.taller01.modelos.DriverLicense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverLicenseRepository  extends JpaRepository<DriverLicense, Long>, JpaSpecificationExecutor<DriverLicense> {
    Optional<DriverLicense> findByLicenseNumber( String licenseNumber);
}
