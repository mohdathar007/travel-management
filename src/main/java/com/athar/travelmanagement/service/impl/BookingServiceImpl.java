package com.athar.travelmanagement.service.impl;


import com.athar.travelmanagement.exception.BookingException;
import com.athar.travelmanagement.exception.BusException;
import com.athar.travelmanagement.exception.CustomerException;
import com.athar.travelmanagement.exception.PackageException;
import com.athar.travelmanagement.model.Booking;
import com.athar.travelmanagement.model.Bus;
import com.athar.travelmanagement.model.Customer;
import com.athar.travelmanagement.model.TravelPackage;
import com.athar.travelmanagement.repository.BookingDAO;
import com.athar.travelmanagement.repository.BusDAO;
import com.athar.travelmanagement.repository.CustomerDAO;
import com.athar.travelmanagement.repository.PackageDAO;
import com.athar.travelmanagement.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingDAO bookingDAO;

    @Autowired
    private PackageDAO pDao;

    @Autowired
    private CustomerDAO customerDao;

    @Autowired
    private BusDAO busDao;

    @Override
    public Booking makeBooking(Integer userId )throws BookingException, CustomerException {
        Customer c = customerDao.findById(userId).orElseThrow(()->new CustomerException("invalid customer id"));
        Booking booking = new Booking();
        booking.setBookingAmt(0.0);
        booking.setBookingDate(LocalDate.now());
        booking.setStatus("pending");
        booking.setCustomer(c);



        List<Booking> bookings = c.getBooking();

        for(int i=0;i<bookings.size();i++) {
            if(bookings.get(i).getStatus().equalsIgnoreCase("pending")) {
                throw new BookingException("Already booking in pending state confirm the past bookings");
            }
        }
        c.getBooking().add(booking);



        return bookingDAO.save(booking);
    }

    @Override
    public Booking cancelBooking(Integer bookingId) throws BookingException {
        Optional<Booking> bookingOptional = bookingDAO.findById(bookingId);
        if (bookingOptional.isPresent()) {
            Booking booking = bookingOptional.get();
            bookingDAO.deleteById(bookingId);

            return booking;
        } else {
            throw new BookingException("Invalid Booking ID");
        }
    }

    @Override
    public Booking viewBooking(Integer bookingId) throws BookingException {
        Optional<Booking> bookingOptional = bookingDAO.findById(bookingId);
        if (bookingOptional.isPresent()) {
            Booking booking = bookingOptional.get();
            return booking;
        } else {
            throw new BookingException("Invalid Booking ID");
        }
    }

    @Override
    public List<Booking> viewAllBookings() throws BookingException {
        List<Booking> list = bookingDAO.findAll();
        if (list.size() == 0) {
            throw new BookingException("no booking is available!!");
        } else {
            return list;
        }
    }

    @Override
    public TravelPackage addTravelPackage(Integer bid, Integer pid) throws BookingException, PackageException {

        Booking b = bookingDAO.findById(bid)
                .orElseThrow(() -> new BookingException("Booking Not Found By booking Id: " + bid));
        TravelPackage p = pDao.findById(pid)
                .orElseThrow(() -> new PackageException("Package Not avilable With Package Id: " + pid));

        b.setPackages(p);


        return pDao.save(p);

    }

    @Override
    public Booking addBusToBooking(Integer busId, Integer BookingId) throws BusException, BookingException {
        Booking b = bookingDAO.findById(BookingId)
                .orElseThrow(() -> new BookingException("Booking Not Found By booking Id: " + BookingId));

        Bus bus = busDao.findById(busId).orElseThrow(()->new BusException("Invalid bus id!!"));


        b.setBus(bus);

        return bookingDAO.save(b);


    }

}