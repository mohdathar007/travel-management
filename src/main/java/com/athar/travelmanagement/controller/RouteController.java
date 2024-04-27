package com.athar.travelmanagement.controller;

import com.athar.travelmanagement.exception.BusException;
import com.athar.travelmanagement.exception.RouteException;
import com.athar.travelmanagement.model.Bus;
import com.athar.travelmanagement.model.Route;
import com.athar.travelmanagement.service.BusService;
import com.athar.travelmanagement.service.RouteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private RouteService rService;
    @Autowired
    private BusService busService;

    @PostMapping("/add")
    public ResponseEntity<Bus> addRouteServices(@RequestParam Integer busId,
                                                @RequestParam Integer routeId) throws BusException, RouteException {
        Bus r = busService.addRouteServices(busId, routeId);
        return new ResponseEntity<Bus>(r, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Route> addRoute(@Valid @RequestBody Route route) throws RouteException {

        Route r = rService.addRoute(route);

        return new ResponseEntity<Route>(r, HttpStatus.OK);

    }



    @PutMapping("/")
    public ResponseEntity<Route> updateRoute(@Valid @RequestBody Route route) throws RouteException {
        Route r = rService.updateRoute(route);
        return new ResponseEntity<Route>(r, HttpStatus.OK);
    }

    @DeleteMapping("/{routeId}")
    public ResponseEntity<Route> removeRoute(@PathVariable("routeId") Integer routeId) throws RouteException {
        Route r = rService.removeRoute(routeId);
        return new ResponseEntity<Route>(r, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Route>> viewRouteList() throws RouteException{
        List<Route> routeList = rService.viewRouteList();
        return new ResponseEntity<List<Route>>(routeList,HttpStatus.OK);

    }





    @GetMapping("/{id}")
    public ResponseEntity<Route> searchRoute(@PathVariable("id")Integer routeId) throws RouteException{

        Route r = rService.searchRoute(routeId);
        return new ResponseEntity<Route>(r,HttpStatus.OK);
    }




}