package edu.unimag.taller01.servicies.impl;

import edu.unimag.taller01.entities.User;
import edu.unimag.taller01.repositories.UserRepository;
import edu.unimag.taller01.servicies.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    UserRepository repository;
    @Override
    public User guardar(User user) {
        return repository.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Optional<User> findById(Long id) {
        return  repository.findById(id);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll().stream().toList();
    }

    @Override
    public void deleteById(Long id) {
        if (!repository.existsById(id)) {
            throw new NoSuchElementException("User not found with ID:  "+ id);

        }
        repository.deleteById(id);

    }

    @Override
    public User updateDriverLicense(Long id, User user) {
        return repository.findById(id).map(
                userInDB ->{
                    userInDB.setEmail(user.getEmail());
                    userInDB.setFullName(user.getFullName());
                    userInDB.setLicense(user.getLicense());
                    userInDB.setPhone(user.getPhone());
                    userInDB.setReservations(user.getReservations());
                    return repository.save(userInDB);

                }).orElseThrow(()-> new NoSuchElementException("User not found with ID:"+ id));
    }
}
