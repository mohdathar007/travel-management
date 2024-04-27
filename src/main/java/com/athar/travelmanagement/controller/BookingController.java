package com.athar.travelmanagement.controller;

import com.athar.travelmanagement.exception.BookingException;
import com.athar.travelmanagement.exception.BusException;
import com.athar.travelmanagement.exception.CustomerException;
import com.athar.travelmanagement.exception.PackageException;
import com.athar.travelmanagement.model.Booking;
import com.athar.travelmanagement.model.TravelPackage;
import com.athar.travelmanagement.service.BookingService;
import com.athar.travelmanagement.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/booking")
public class BookingController {


    @Autowired
    private BookingService bookingService;




    @Autowired
    private RouteService rService;


    @DeleteMapping("/{id}")
    public ResponseEntity<Booking> cancelBooking(@PathVariable("id") Integer id) throws BookingException {
        Booking booking= bookingService.cancelBooking(id);
        return new ResponseEntity<Booking>(booking,HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Booking> viewBooking(@PathVariable("id") Integer id) throws BookingException{
        Booking booking= bookingService.viewBooking(id);
        return new ResponseEntity<Booking>(booking,HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<Booking>> viewAllBooking() throws BookingException{
        List<Booking> list = bookingService.viewAllBookings();
        return new ResponseEntity<List<Booking>>(list,HttpStatus.OK);
    }






    @PostMapping("/add")
    public ResponseEntity<TravelPackage> addPackage(@RequestParam Integer bid,@RequestParam Integer pid) throws PackageException, BookingException{
        TravelPackage package2=bookingService.addTravelPackage(bid, pid);
        return new ResponseEntity<TravelPackage>(package2, HttpStatus.CREATED);
    }

    @PostMapping("/{userId}")
    public ResponseEntity<Booking> makeBooking( @PathVariable("userId") Integer userId) throws BookingException, CustomerException {
        Booking newBooking=bookingService.makeBooking(userId);
        return new ResponseEntity<Booking>(newBooking, HttpStatus.CREATED);
    }


    @PostMapping("/bus")
    public ResponseEntity<Booking> addBusToBooking(@RequestParam Integer busId,@RequestParam Integer BookingId)throws BusException,BookingException{
        return new ResponseEntity<Booking>(bookingService.addBusToBooking(busId, BookingId),HttpStatus.OK);
    };







}