package edu.unimag.taller01.servicies.impl;

import edu.unimag.taller01.entities.Station;
import edu.unimag.taller01.repositories.StationRepository;
import edu.unimag.taller01.servicies.StationService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
@Service @RequiredArgsConstructor
public class StationServiceImpl implements StationService {

    private final StationRepository stationRepository;
    @Override@Transactional
    public Station createStation(Station station) {
        return stationRepository.save(station);
    }

    @Override@Transactional
    public Station updateStation(Long id,Station station) {
        return stationRepository.findById(id).map(
                stationInDB ->{
                    stationInDB.setAddress(station.getAddress());
                    stationInDB.setCity(station.getCity());
                    stationInDB.setName(station.getName());
                    stationInDB.setVehicles(station.getVehicles());

                    return stationRepository.save(stationInDB);

                }).orElseThrow(()-> new NoSuchElementException("Station not found with ID:"+ id));
    }

    @Override
    public Optional<Station> findById(Long id) {
        return stationRepository.findById(id);
    }

    @Override
    public Optional<Station> findByAdress(String Adress) {
        return stationRepository.findByAdress(Adress);
    }

    @Override
    public List<Station> findAll() {
        return stationRepository.findAll();
    }

    @Override@Transactional
    public void deleteStation(Long id) {
        stationRepository.deleteById(id);

    }
}
