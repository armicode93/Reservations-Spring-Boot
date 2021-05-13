package be.iccbxl.pid.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class LocationService {
    @Autowired
    private LocationRepository repository;   //repository

    public List<Location> getAll()
    {
        List<Location> locations = new ArrayList<>();
        repository.findAll().forEach(locations::add);

        return locations;
    }
    public Location get(String id)
    {
        Long indice =(long) Integer.parseInt(id);

        Optional<Location> location = repository.findById(indice);

        return location.isPresent() ? location.get() : null;
    }
    public void add(Location location) {

        repository.save(location);
    }

    public void update(String id, Location location) {

        repository.save(location);
    }

    public void delete(String id) {
        Long indice = (long) Integer.parseInt(id);
        repository.deleteById(indice);

    }
}
