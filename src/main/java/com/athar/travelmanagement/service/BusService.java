package com.athar.travelmanagement.service;

import com.athar.travelmanagement.exception.BusException;
import com.athar.travelmanagement.exception.CustomerException;
import com.athar.travelmanagement.exception.RouteException;
import com.athar.travelmanagement.model.Booking;
import com.athar.travelmanagement.model.Bus;

import java.util.List;


public interface BusService {

    public Bus addBus(Bus bus) throws BusException;

    public Bus searchBusByid(Integer busId) throws BusException;

    public Bus updateBus(Bus bus) throws BusException;


    public List<Bus> veiwAllBuses() throws BusException;



    public Bus addRouteServices(Integer busId, Integer routeId) throws BusException, RouteException;

    public Bus deleteBus(Integer busId) throws BusException;


    public Booking addBusToBooking(Integer bId, Integer busId) throws BusException, CustomerException;
}