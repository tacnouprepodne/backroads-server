package com.backroads.service.impl;

import com.backroads.entity.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.backroads.repository.LocationRepository;
import com.backroads.service.LocationService;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {
    @Autowired
    private LocationRepository repository;


    @Override
    public void delete(Location location) {
        repository.delete(location);
    }

    @Override
    public void save(Location location) {
        repository.save(location);
    }

    @Override
    public Location findOne(Long id) {
        return repository.getOne(id);
    }

    @Override
    public List<Location> findAll() {
        return repository.findAll();
    }
}
