package edu.unimag.taller01.servicies;

import edu.unimag.taller01.entities.Station;

import java.util.List;
import java.util.Optional;

public interface StationService {

    Station createStation(Station station);
    Station updateStation(Long id,Station station);
    Optional<Station> findById(Long id);
    Optional<Station> findByAdress(String Adress);
    List<Station> findAll();
    void deleteStation(Long id);

}
