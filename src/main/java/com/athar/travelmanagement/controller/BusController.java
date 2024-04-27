package com.athar.travelmanagement.controller;

import com.athar.travelmanagement.exception.BusException;
import com.athar.travelmanagement.exception.CustomerException;
import com.athar.travelmanagement.model.Booking;
import com.athar.travelmanagement.model.Bus;
import com.athar.travelmanagement.service.BusService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bus")
public class BusController {

    @Autowired
    private BusService busService;


    @PostMapping("/")
    public ResponseEntity<Bus> addBus(@Valid @RequestBody Bus bus) throws BusException {
        Bus b = busService.addBus(bus);
        return new ResponseEntity<Bus>(b, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Bus> updateBus(@Valid @RequestBody Bus bus) throws BusException {

        Bus b = busService.updateBus(bus);
        return new ResponseEntity<Bus>(b, HttpStatus.OK);

    }

    @GetMapping("/{busid}")
    public ResponseEntity<Bus> searchBusByBusId(@PathVariable("busid") Integer busId) throws BusException {

        Bus bus = busService.searchBusByid(busId);
        return new ResponseEntity<Bus>(bus, HttpStatus.OK);
    }



    @GetMapping("/all")
    public ResponseEntity<List<Bus>> veiwAllBuses() throws BusException {
        List<Bus> bList = busService.veiwAllBuses();
        return new ResponseEntity<List<Bus>>(bList, HttpStatus.OK);
    }

    @DeleteMapping("/{busid}")
    public ResponseEntity<Bus> deleteBusByBusId(@PathVariable("busid") Integer busId) throws BusException {

        Bus bus = busService.deleteBus(busId);
        return new ResponseEntity<Bus>(bus, HttpStatus.OK);
    }


    @PostMapping("/booking")
    public ResponseEntity<Booking> addBusToBooking(Integer bId, Integer busId) throws BusException, CustomerException {
        return new ResponseEntity<Booking>(busService.addBusToBooking(bId, busId),HttpStatus.OK);
    };






}