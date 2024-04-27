package com.athar.travelmanagement.controller;

import com.athar.travelmanagement.exception.HotelException;
import com.athar.travelmanagement.exception.PackageException;
import com.athar.travelmanagement.model.Hotel;
import com.athar.travelmanagement.model.TravelPackage;
import com.athar.travelmanagement.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/hotel")
public class HotelController {


    @Autowired
    private HotelService hotelService;




    @GetMapping("/{hId}/{pId}")
    public ResponseEntity<TravelPackage> addPackage(@PathVariable("hId") Integer hotelId, @PathVariable("pId") Integer packageId) throws HotelException, PackageException {

        TravelPackage p = hotelService.addPackage(hotelId, packageId);

        return new ResponseEntity<TravelPackage>(p,HttpStatus.OK);
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<Hotel> deleteHotel(@PathVariable("hotelId") Integer hotelId) throws HotelException {
        return new ResponseEntity<Hotel>(hotelService.deleteHotel(hotelId), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Hotel> addHotel(@RequestBody Hotel hotel) throws HotelException {
        Hotel h = hotelService.addHotel(hotel);
        return new ResponseEntity<Hotel>(h, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> findByHotelId(@PathVariable("hotelId") Integer hotelId) throws HotelException {
        return new ResponseEntity<Hotel>(hotelService.findByHotelId(hotelId), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Hotel>> viewAllHotels() throws HotelException{
        return new ResponseEntity<List<Hotel>>(hotelService.viewAllHotels(),HttpStatus.OK);
    };






}