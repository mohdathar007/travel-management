package com.athar.travelmanagement.service.impl;

import com.athar.travelmanagement.exception.BookingException;
import com.athar.travelmanagement.exception.HotelException;
import com.athar.travelmanagement.exception.PackageException;
import com.athar.travelmanagement.model.Booking;
import com.athar.travelmanagement.model.Hotel;
import com.athar.travelmanagement.model.TravelPackage;
import com.athar.travelmanagement.repository.BookingDAO;
import com.athar.travelmanagement.repository.HotelDAO;
import com.athar.travelmanagement.repository.PackageDAO;
import com.athar.travelmanagement.service.TravelPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TravelPackageServiceImpl implements TravelPackageService {

    @Autowired
    private PackageDAO packageDAO;

    @Autowired
    private BookingDAO bookingDAO;

    @Autowired
    HotelDAO hotelDAO;


    @Override
    public TravelPackage deletePackage(Integer id) throws PackageException {
        Optional<TravelPackage> packageOptional= packageDAO.findById(id);
        if(packageOptional.isPresent()) {
            TravelPackage package1 = packageOptional.get();
            packageDAO.deleteById(id);
            return package1;
        }
        else {
            throw new PackageException("Invalid Package ID");
        }
    }

    @Override
    public TravelPackage searchPackage(Integer id) throws PackageException {
        Optional<TravelPackage> packageOptional= packageDAO.findById(id);
        if(packageOptional.isPresent()) {
            TravelPackage package1 = packageOptional.get();
            return package1;
        }
        else {
            throw new PackageException("Invalid Package ID");
        }
    }

    @Override
    public List<TravelPackage> viewAllPackage() throws PackageException {
        List<TravelPackage> list= packageDAO.findAll();
        if(list.size()==0) {
            throw new PackageException("no package is available!!");
        }
        else {
            return list;
        }
    }

    @Override
    public Booking addPackageToBooking(Integer bId, Integer pId) throws PackageException, BookingException {
        Optional<TravelPackage> packageOptional= packageDAO.findById(pId);
        if(packageOptional.isPresent()) {
            TravelPackage package1 = packageOptional.get();
            Booking b = bookingDAO.findById(bId).orElseThrow(()->new BookingException("Invalid booking ID!"));
//			package1.setBooking(b);
            package1.setPackageCost(package1.getHotel().getHotelPrice()*package1.getNoOfDays());
            b.setPackages(package1);


            return bookingDAO.save(b);
        }
        else {
            throw new PackageException("Invalid Package ID");
        }
    }

    @Override
    public TravelPackage registerPackage(TravelPackage package1) throws PackageException {

        return packageDAO.save(package1);
    }

    @Override
    public TravelPackage addHotelToPackage(Integer hotelId, Integer pkgId) throws PackageException, HotelException {
        Optional<TravelPackage> packageOptional= packageDAO.findById(pkgId);
        if(packageOptional.isPresent()) {
            Hotel h = hotelDAO.findById(hotelId).orElseThrow(()->new HotelException("Invalid hotel Id!!"));
            TravelPackage package1 = packageOptional.get();
            package1.setHotel(h);
            return packageDAO.save(package1);
        }
        else {
            throw new PackageException("Invalid Package ID");
        }
    }



}