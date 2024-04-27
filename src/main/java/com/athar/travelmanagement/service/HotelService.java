package com.athar.travelmanagement.service;

import com.athar.travelmanagement.exception.HotelException;
import com.athar.travelmanagement.exception.PackageException;
import com.athar.travelmanagement.model.Hotel;
import com.athar.travelmanagement.model.TravelPackage;

import java.util.List;

public interface HotelService {

    public Hotel addHotel(Hotel hotel) throws HotelException;

    public Hotel deleteHotel(Integer hotelId) throws HotelException;

    public Hotel findByHotelId(Integer hotelId) throws HotelException;

    public List<Hotel> viewAllHotels() throws HotelException;

    public TravelPackage addPackage(Integer hoteId, Integer packageId) throws HotelException, PackageException;
}