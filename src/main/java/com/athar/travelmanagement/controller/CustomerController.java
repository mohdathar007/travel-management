package com.athar.travelmanagement.controller;

import com.athar.travelmanagement.exception.CustomerException;
import com.athar.travelmanagement.exception.FeedbackException;
import com.athar.travelmanagement.exception.LoginException;
import com.athar.travelmanagement.model.Customer;
import com.athar.travelmanagement.model.Feedback;
import com.athar.travelmanagement.model.LoginDTO;
import com.athar.travelmanagement.service.CustomerService;
import com.athar.travelmanagement.service.FeedbackService;
import com.athar.travelmanagement.service.PaymentService;
import com.athar.travelmanagement.service.impl.CustomerLoginServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private FeedbackService feedbackService;



    @Autowired
    private CustomerService cService;


    @Autowired
    private PaymentService paymentService;


    @Autowired
    private CustomerLoginServiceImpl customerLoginServiceImpl;



    // for user login
    @PostMapping("/userlogin")
    public String loginCustomerr(@Valid @RequestBody LoginDTO customerDTO) throws Exception {
        return customerLoginServiceImpl.logIntoAccount(customerDTO);
    }

    // for user logout
    @PostMapping("/userlogout")
    public String logOutCustomerr(@RequestParam(required = false) String key) throws LoginException {
        return customerLoginServiceImpl.logOutFromAccount(key);
    }



    ///////////////////////////Customer Controller Part

    @PostMapping("/")
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) throws CustomerException {

        Customer c = cService.createCustomer(customer);

        return new ResponseEntity<Customer>(c, HttpStatus.OK);

    }

    @PutMapping("/{key}")
    public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer costumer,
                                                   @PathVariable("key") String key) throws CustomerException {

        Customer updateCu = cService.updateCustomer(costumer, key);

        return new ResponseEntity<>(updateCu, HttpStatus.OK);

    }


    @GetMapping("/all")
    public ResponseEntity<java.util.List<Customer>> getAllCustomer() throws CustomerException{

        java.util.List<Customer> customers=cService.allCustomer();

        return new ResponseEntity<java.util.List<Customer>>(customers,HttpStatus.OK);

    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Integer id) throws CustomerException{

        Customer customers=cService.viewCustomer(id);

        return new ResponseEntity<Customer>(customers,HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Customer> deleteCustomerById(@PathVariable("id") Integer id) throws CustomerException{

        Customer customers=cService.deleteCustomerById(id);

        return new ResponseEntity<Customer>(customers,HttpStatus.OK);

    }



    ///////////////////////////feedback Controller Part

    @GetMapping("/feedbackcustomer/{customerId}")
    public ResponseEntity<List<Feedback>> findByCustomerId(@PathVariable("customerId") Integer customerId)
            throws FeedbackException, CustomerException {

        List<Feedback> feedBacks = feedbackService.findByCustomerId(customerId);

        return new ResponseEntity<List<Feedback>>(feedBacks, HttpStatus.OK);

    }

    @GetMapping("/feedbacks")
    public ResponseEntity<List<Feedback>> viewAllFeedbacks() throws FeedbackException {
        return new ResponseEntity<List<Feedback>>(feedbackService.viewAllFeedbacks(), HttpStatus.OK);
    }

    @PostMapping("/feedbacks/{customerId}")
    public ResponseEntity<Feedback> addFeedback(@Valid @RequestBody Feedback feedback,
                                                @PathVariable("customerId") Integer customerId) throws FeedbackException, CustomerException {

        return new ResponseEntity<Feedback>(feedbackService.addFeedback(feedback, customerId), HttpStatus.ACCEPTED);
    }





}