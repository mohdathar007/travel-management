package com.athar.travelmanagement.service.impl;

import com.athar.travelmanagement.exception.*;
import com.athar.travelmanagement.model.Booking;
import com.athar.travelmanagement.model.PaymentDetails;
import com.athar.travelmanagement.model.Wallet;
import com.athar.travelmanagement.repository.BookingDAO;
import com.athar.travelmanagement.repository.PaymentDAO;
import com.athar.travelmanagement.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    BookingDAO bookingDAO;

    @Autowired
    PaymentDAO paymentDao;

    @Override
    public PaymentDetails payment(Integer bookingId)
            throws PackageException, PaymentException, BookingException, HotelException, BusException {
        Booking b = bookingDAO.findById(bookingId).orElseThrow(()->new BookingException("Invalid booking Id!!"));

        if(b.getBus()==null) {
            throw new BusException("bus not added in the booking add bus for package confirmation!");
        }
        if(b.getPackages()==null) {
            throw new PackageException("package is not selected please select package before any payment!");
        }

        b.setBookingAmt(b.getPackages().getNoOfDays()*b.getPackages().getHotel().getHotelPrice()+b.getBus().getFare());

        PaymentDetails pd = new PaymentDetails();
        pd.setAddress(b.getCustomer().getAddress());
        pd.setBooking(b);
        pd.setName(b.getCustomer().getName());
        pd.setTime(LocalDate.now());
        pd.setTotalAmount(b.getBookingAmt());
        if(pd.getBooking().getCustomer().getWallet().getWalletBalance()>pd.getBooking().getBookingAmt()) {
            b.setStatus("Booking confiremed!!");
            pd.setStatus("payment done!");

            pd.getBooking().getCustomer().getWallet()
                    .setWalletBalance(pd.getBooking()
                            .getCustomer().getWallet()
                            .getWalletBalance()-pd.getBooking().getBookingAmt());

            PaymentDetails p =  paymentDao.save(pd);
            Wallet w = pd.getBooking().getCustomer().getWallet();

            return p;
        }else {
            throw new PaymentException("not sufficieant balance in user wallet!!");
        }






    }

    @Override
    public List<PaymentDetails> veiwAllPayments() throws PaymentException {
        // TODO Auto-generated method stub
        return null;
    }

}