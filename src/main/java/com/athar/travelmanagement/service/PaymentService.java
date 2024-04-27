package com.athar.travelmanagement.service;

import com.athar.travelmanagement.exception.*;
import com.athar.travelmanagement.model.PaymentDetails;

import java.util.List;

public interface PaymentService {

    public PaymentDetails payment(Integer bookingId) throws PackageException, PaymentException, BookingException, HotelException, BusException;

    public List<PaymentDetails> veiwAllPayments() throws PaymentException;


}