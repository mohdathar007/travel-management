package com.athar.travelmanagement.controller;

import com.athar.travelmanagement.exception.*;
import com.athar.travelmanagement.model.PaymentDetails;
import com.athar.travelmanagement.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/{bId}")
    public ResponseEntity<PaymentDetails> payment(@PathVariable("bId") Integer bookingId) throws PackageException, PaymentException, BookingException, HotelException, BusException {
        return new ResponseEntity<PaymentDetails>(paymentService.payment(bookingId),HttpStatus.ACCEPTED);
    };

}