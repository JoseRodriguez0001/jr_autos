package edu.unimag.taller01.servicies;

import edu.unimag.taller01.entities.DriverLicense;
import edu.unimag.taller01.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User guardar(User user);
    Optional<User> findByEmail(String email);
    Optional<User> findById( Long id);
    List<User> findAll();
    void deleteById( Long id);
    User updateDriverLicense(Long id,User user);

}
