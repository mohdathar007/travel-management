package com.athar.travelmanagement.service;

import com.athar.travelmanagement.exception.BookingException;
import com.athar.travelmanagement.exception.HotelException;
import com.athar.travelmanagement.exception.PackageException;
import com.athar.travelmanagement.model.Booking;
import com.athar.travelmanagement.model.TravelPackage;

import java.util.List;

public interface TravelPackageService {
    public Booking addPackageToBooking(Integer bId, Integer pId)throws PackageException, BookingException;
    public TravelPackage addHotelToPackage(Integer hotelId, Integer pkgId)throws PackageException, HotelException;
    public TravelPackage registerPackage(TravelPackage package1)throws PackageException;
    public TravelPackage deletePackage(Integer id)throws PackageException;
    public TravelPackage searchPackage(Integer id)throws PackageException;
    public List<TravelPackage> viewAllPackage()throws PackageException;
}