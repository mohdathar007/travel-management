package com.athar.travelmanagement.service.impl;

import com.athar.travelmanagement.exception.RouteException;
import com.athar.travelmanagement.model.Route;
import com.athar.travelmanagement.repository.BusDAO;
import com.athar.travelmanagement.repository.RouteDAO;
import com.athar.travelmanagement.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class RouteServiceImpl implements RouteService {

    @Autowired
    private RouteDAO rDao;
    @Autowired
    private BusDAO bDao;



    @Override
    public Route addRoute(Route route) throws RouteException {

        if(route.getRouteFrom().equalsIgnoreCase("") || route.getRouteTo().equalsIgnoreCase("") ) {
            throw new RouteException("please fill all the fields of route!");
        }



        return rDao.save(route);

    }



    @Override
    public Route removeRoute(Integer routeId) throws RouteException {

        Optional<Route> exsistingRoute=rDao.findById(routeId);
        if (!exsistingRoute.isPresent()) {
            throw new RouteException("This Route is not present in database to delete.");
        }
        rDao.delete(exsistingRoute.get());
        return exsistingRoute.get();
    }

    @Override
    public Route searchRoute(Integer routeId) throws RouteException {

        Optional<Route> exsistingRoute = rDao.findById(routeId);

        if(!exsistingRoute.isPresent()) {
            throw new RouteException("This route is not present!!");
        }else {
            return exsistingRoute.get();
        }

    }

    @Override
    public List<Route> viewRouteList() throws RouteException {

        List<Route> exsistingRouteList = rDao.findAll();

        if(exsistingRouteList.size()==0) {
            throw new RouteException("No route is present to travel!!");
        }else {
            return exsistingRouteList;
        }
    }

    @Override
    public Route updateRoute(Route route) throws RouteException {
        Optional<Route> exsistingRoute = rDao.findById(route.getRouteId());

        if(exsistingRoute.isPresent()) {
            Route updatedRoute = rDao.save(route);
            return updatedRoute;

        }else {
            throw new RouteException("No such route is present to update!!");
        }

    }

}