package com.athar.travelmanagement.service;

import com.athar.travelmanagement.exception.BookingException;
import com.athar.travelmanagement.exception.BusException;
import com.athar.travelmanagement.exception.CustomerException;
import com.athar.travelmanagement.exception.PackageException;
import com.athar.travelmanagement.model.Booking;
import com.athar.travelmanagement.model.TravelPackage;

import java.util.List;

public interface BookingService {
    public Booking makeBooking(Integer userId)throws BookingException, CustomerException;
    public Booking cancelBooking(Integer bookingId)throws BookingException;
    public Booking viewBooking(Integer bookingId)throws BookingException;
    public List<Booking> viewAllBookings()throws BookingException;
    public TravelPackage addTravelPackage(Integer bid, Integer pid) throws BookingException, PackageException;

    public Booking addBusToBooking(Integer busId,Integer BookingId)throws BusException,BookingException;


}