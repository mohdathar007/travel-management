package com.athar.travelmanagement.service;

import com.athar.travelmanagement.exception.RouteException;
import com.athar.travelmanagement.model.Route;

import java.util.List;


public interface RouteService {

    public Route addRoute(Route route) throws RouteException;
    public Route removeRoute(Integer routeId) throws RouteException;
    public Route searchRoute(Integer routeId) throws RouteException;
    public List<Route> viewRouteList() throws RouteException;
    public Route updateRoute(Route route) throws RouteException;
}