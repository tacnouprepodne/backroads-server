package com.backroads.dto;

import com.backroads.entity.Location;
import com.backroads.entity.Season;

import java.util.Date;


public class DestinationDTO {
    private Long id;
    private String name;
    private String country;
    private int price;
    private Date from;
    private Date to;
    private String description;
    private String picture;

    private LocationDTO location;
    private SeasonDTO season;
    public DestinationDTO() {
    }



    public DestinationDTO(Long id, String name, String country, int price, Date from, Date to, String description, String picture, LocationDTO location, SeasonDTO season) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.price = price;
        this.from = from;
        this.to = to;
        this.description = description;
        this.picture = picture;
        this.location = location;
        this.season = season;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public LocationDTO getLocation() {
        return location;
    }

    public void setLocation(LocationDTO location) {
        this.location = location;
    }

    public SeasonDTO getSeason() {
        return season;
    }

    public void setSeason(SeasonDTO season) {
        this.season = season;
    }
}
