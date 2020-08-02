package com.backroads.controller;

import com.backroads.common.DestinationToDestinationDTO;
import com.backroads.common.RandomPhotos;
import com.backroads.dto.DestinationDTO;
import com.backroads.entity.Destination;
import com.backroads.entity.Location;
import com.backroads.repository.DestinationRepository;
import com.backroads.repository.LocationRepository;
import com.fasterxml.jackson.databind.JsonMappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParseException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.backroads.service.DestinationService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping(value="api/destination")
@CrossOrigin("*")
public class DestinationController {
    @Autowired
    private DestinationService service;
    @Autowired
    private DestinationToDestinationDTO toDTO;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<DestinationDTO>>findAll(@RequestParam() int pageNum, @RequestParam() int pageSize, @RequestParam() String sortLocation, @RequestParam() String sortSeason,@RequestParam() String order_by) {
        HttpHeaders headers = new HttpHeaders();
        if(sortLocation.equals("*")){
            sortLocation="%";
        }
        if(sortSeason.equals("*")){
            sortSeason="%";
        }
        Page<Destination> destinations=service.search(sortLocation,sortSeason,order_by,pageNum,pageSize);
        headers.add("totalPages", Integer.toString(destinations.getTotalPages()));
        headers.add("access-control-expose-headers","totalPages");
        headers.add("totalElements", Long.toString(destinations.getTotalElements()));
        headers.add("access-control-expose-headers","totalElements");
        return new ResponseEntity<>(toDTO.convert(destinations.getContent()),headers, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET,value = "/{id}")
    public ResponseEntity<DestinationDTO>findById(@PathVariable Long id){

        Destination destination=service.findOne(id);
        if(destination==null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(toDTO.convert(destination), HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.GET,value = "/photos")
    public ResponseEntity<List<RandomPhotos>>random(){
        List<RandomPhotos>randomPhotos=new ArrayList<>();
        List<Destination> destinations = service.findAll();
        List<Integer> numbers = new ArrayList<Integer>();
        Random randomGenerator = new Random();
        while (numbers.size() < 8) {

            int random = randomGenerator .nextInt(destinations.size())+1;
            if (!numbers.contains(random)) {
                numbers.add(random);
                Destination destination=service.findOne((long)random);
                randomPhotos.add(new RandomPhotos(destination.getId(),destination.getPicture()));
            }
        }
        return new ResponseEntity<>(randomPhotos,HttpStatus.OK);
    }
}
