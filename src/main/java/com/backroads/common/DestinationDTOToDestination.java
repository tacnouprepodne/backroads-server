package com.backroads.common;

import com.backroads.dto.DestinationDTO;
import com.backroads.entity.Destination;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import com.backroads.service.DestinationService;

@Component
public class DestinationDTOToDestination implements Converter<DestinationDTO, Destination> {
    @Autowired
    private DestinationService service;
    @Override
    public Destination convert(DestinationDTO source) {
        Destination destination;
        if(source.getId()==null){
            destination=new Destination();
        }else{
            destination=service.findOne(source.getId());
        }
        destination.setName(source.getName());
        destination.setCountry(source.getCountry());
        destination.setDescription(source.getDescription());
        destination.setPicture(source.getPicture());
        destination.setPicture(source.getPicture());
        destination.setD_from(source.getFrom());
        destination.setD_to(source.getTo());
//        destination.setSeason(source.getSeason());
//        destination.setLocation(source.getLocation());
        return destination;
    }
}
