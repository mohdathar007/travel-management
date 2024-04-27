package com.athar.travelmanagement.controller;

import com.athar.travelmanagement.exception.*;
import com.athar.travelmanagement.model.*;
import com.athar.travelmanagement.service.*;
import com.athar.travelmanagement.service.impl.AdminLoginServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminLoginServiceImpl adminLogInServiceImpl;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private FeedbackService feedbackService;


    @Autowired
    private CustomerService cService;

    @Autowired
    private ReportService reportService;






    @Autowired
    private TravelPackageService packageService;

    @Autowired
    private PaymentService paymentService;


    @Autowired
    private HotelService hotelService;

    @Autowired
    private AdminService aService;



    // for admin login

    @PostMapping("/adminlogin")
    public String logInAdmin(@Valid @RequestBody LoginDTO adminDTO) throws LoginException {
        return adminLogInServiceImpl.logIntoAccount(adminDTO);
    }

    // for admin logout

    @PostMapping("/adminlogout")
    public String logOutAdmin(@RequestParam(required = false) String key) throws LoginException {
        return adminLogInServiceImpl.logOutFromAccount(key);
    }

    @PostMapping()
    public ResponseEntity<Admin> addAdmin(@RequestBody Admin admin) throws AdminException {

        return new ResponseEntity<Admin>(aService.addAdmin(admin),HttpStatus.ACCEPTED);
    }



    /////////////////////////// Report Controller Part

    @GetMapping("/report/reports")
    public ResponseEntity<List<Report>> viewAllReports() throws ReportException {
        return new ResponseEntity<List<Report>>(reportService.viewAllReports(), HttpStatus.OK);
    }
    @PostMapping("/report/reports")
    public ResponseEntity<Report> addReport(@Valid @RequestBody Report report) throws ReportException {
        return new ResponseEntity<Report>(reportService.addReport(report), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/report/reports/{reportId}")
    public ResponseEntity<Report> deleteReport(@PathVariable("reportId") Integer reportId) throws ReportException {
        return new ResponseEntity<Report>(reportService.deleteReport(reportId), HttpStatus.OK);
    }

    @GetMapping("/report/reports/{reportId}")
    public ResponseEntity<Report> findByReportId(@PathVariable("reportId") Integer reportId) throws ReportException {
        return new ResponseEntity<Report>(reportService.findByReportId(reportId), HttpStatus.OK);
    }





    ///////////////payment controller////////////////
    @GetMapping("payment/payments")
    public ResponseEntity<List<PaymentDetails>> veiwAllPayments() throws PaymentException {
        List<PaymentDetails> pList = paymentService.veiwAllPayments();
        return new ResponseEntity<List<PaymentDetails>>(pList,HttpStatus.OK);
    }





    ///////////////////////////feedback Controller Part

    @GetMapping("/feedbacks")
    public ResponseEntity<List<Feedback>> viewAllFeedbacks() throws FeedbackException {
        return new ResponseEntity<List<Feedback>>(feedbackService.viewAllFeedbacks(), HttpStatus.OK);
    }

    @GetMapping("/feedbackcustomer/{customerId}")
    public ResponseEntity<List<Feedback>> findByCustomerId(@PathVariable("customerId") Integer customerId)
            throws FeedbackException, CustomerException {

        List<Feedback> feedBacks = feedbackService.findByCustomerId(customerId);

        return new ResponseEntity<List<Feedback>>(feedBacks, HttpStatus.OK);

    }

    @GetMapping("/feedbacks/{feedbackId}")
    public ResponseEntity<Feedback> findByFeeedbackId(@PathVariable("feedbackId") Integer feedbackId)
            throws FeedbackException {
        return new ResponseEntity<Feedback>(feedbackService.findByFeeedbackId(feedbackId), HttpStatus.OK);
    }



    ///////////////////////////booking Controller Part

    @DeleteMapping("/cancelbooking/{id}")
    public ResponseEntity<Booking> cancelBooking(@PathVariable("id") Integer id) throws BookingException{
        Booking booking= bookingService.cancelBooking(id);
        return new ResponseEntity<Booking>(booking,HttpStatus.OK);
    }


    @GetMapping("/viewbooking/{id}")
    public ResponseEntity<Booking> viewBooking(@PathVariable("id") Integer id) throws BookingException{
        Booking booking= bookingService.viewBooking(id);
        return new ResponseEntity<Booking>(booking,HttpStatus.OK);
    }

    @GetMapping("/allBookings")
    public ResponseEntity<List<Booking>> viewAllBooking() throws BookingException{
        List<Booking> list = bookingService.viewAllBookings();
        return new ResponseEntity<List<Booking>>(list,HttpStatus.OK);
    }




}