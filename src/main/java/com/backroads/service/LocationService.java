package com.backroads.service;

import com.backroads.entity.Location;


import java.util.List;

public interface LocationService {
    void delete(Location location);
    void save (Location location);
    Location findOne(Long id);
    List<Location> findAll();
}
