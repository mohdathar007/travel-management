package com.athar.travelmanagement.controller;

import com.athar.travelmanagement.exception.BookingException;
import com.athar.travelmanagement.exception.HotelException;
import com.athar.travelmanagement.exception.PackageException;
import com.athar.travelmanagement.model.Booking;
import com.athar.travelmanagement.model.TravelPackage;
import com.athar.travelmanagement.service.TravelPackageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/package")
public class PackageController {




    @Autowired
    private TravelPackageService packageService;



    @GetMapping("/all")
    public ResponseEntity<List<TravelPackage>> viewAllPackage() throws PackageException {
        List<TravelPackage> list = packageService.viewAllPackage();
        return new ResponseEntity<List<TravelPackage>>(list,HttpStatus.OK);
    }

    @GetMapping("/{pid}")
    public ResponseEntity<TravelPackage> viewPackage(@PathVariable("pid") Integer id) throws PackageException{
        TravelPackage package1= packageService.searchPackage(id);
        return new ResponseEntity<TravelPackage>(package1,HttpStatus.OK);
    }

    @PostMapping("/addHotel")
    public ResponseEntity<TravelPackage> addHotelToPackage(@RequestParam Integer hotelId,@RequestParam Integer pkgId)throws PackageException, HotelException {
        return new ResponseEntity<TravelPackage>(packageService.addHotelToPackage(hotelId, pkgId),HttpStatus.OK);
    };


    @PostMapping("/")
    public ResponseEntity<TravelPackage> addPackage(@Valid @RequestBody TravelPackage package1) throws PackageException{
        TravelPackage package2=packageService.registerPackage(package1);
        return new ResponseEntity<TravelPackage>(package2, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TravelPackage> deletePackage(@PathVariable("id") Integer id) throws PackageException{
        TravelPackage package1= packageService.deletePackage(id);
        return new ResponseEntity<TravelPackage>(package1,HttpStatus.OK);
    }

    @PostMapping("/book")
    public ResponseEntity<Booking> addPackageToBooking(@RequestParam Integer bId, @RequestParam Integer pId)throws PackageException, BookingException {
        return new ResponseEntity<Booking>(packageService.addPackageToBooking(bId, pId),HttpStatus.OK);
    };






}