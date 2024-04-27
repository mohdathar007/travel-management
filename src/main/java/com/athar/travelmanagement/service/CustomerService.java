package com.athar.travelmanagement.service;

import com.athar.travelmanagement.exception.CustomerException;
import com.athar.travelmanagement.model.Customer;

import java.util.List;

public interface CustomerService {

    public Customer createCustomer(Customer customer) throws CustomerException;
    public Customer updateCustomer(Customer customer, String key) throws CustomerException;
    public Customer deleteCustomer(Customer customer) throws CustomerException;
    public Customer deleteCustomerById(Integer id) throws CustomerException;
    public Customer viewCustomer(Integer cid) throws CustomerException;
    public List<Customer> allCustomer() throws CustomerException;

}