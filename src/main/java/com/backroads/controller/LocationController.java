package com.backroads.controller;

import com.backroads.common.LocationToLocationDTO;
import com.backroads.common.SeasonToSeasonDTO;
import com.backroads.dto.LocationDTO;
import com.backroads.dto.SeasonDTO;
import com.backroads.entity.Location;
import com.backroads.entity.Season;
import com.backroads.service.LocationService;
import com.backroads.service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="api/location")
@CrossOrigin("*")
public class LocationController {
    @Autowired
    private LocationService service;
    @Autowired
    private LocationToLocationDTO toDTO;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<LocationDTO>> findAll() {
        List<Location> locations=service.findAll();
        return new ResponseEntity<>(toDTO.convert(locations), HttpStatus.OK);
    }
}
