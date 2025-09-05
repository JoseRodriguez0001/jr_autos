package edu.unimag.taller01.repositories;

import edu.unimag.taller01.entities.DriverLicense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DriverLicenseRepository  extends JpaRepository<DriverLicense, Long>, JpaSpecificationExecutor<DriverLicense> {
    Optional<DriverLicense> findByLicenseNumber( String licenseNumber);
    List<DriverLicense> id(Long id);
    //Solo se implementan consultas complejas
}
