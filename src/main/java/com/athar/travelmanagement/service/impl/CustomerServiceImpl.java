package com.athar.travelmanagement.service.impl;

import com.athar.travelmanagement.exception.CustomerException;
import com.athar.travelmanagement.model.Customer;
import com.athar.travelmanagement.model.Wallet;
import com.athar.travelmanagement.repository.CustomerDAO;
import com.athar.travelmanagement.repository.SessionDAO;
import com.athar.travelmanagement.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO cDao;

    @Autowired
    private SessionDAO sDao;

    @Override
    public Customer createCustomer(Customer customer) throws CustomerException {


//		Customer exsistingcustomer = cDao.findByMobileNo(customer.getMobileNo());
//
//		if (exsistingcustomer != null) {
//			throw new CustomerException("customer already registerd with mobile number!!");
//		}
        Wallet w = new Wallet();
        w.setWalletBalance(10000);
        customer.setWallet(w);

        return cDao.save(customer);
    }

    @Override
    public Customer updateCustomer(Customer customer, String key) throws CustomerException {
//		currentUserSession loggedInUser = sDao.findByUuid(key);
//
//		if (loggedInUser == null) {
//			throw new CustomerException("please provide the valid key to update the customer!!");
//		}

//		if (customer.getCustomerId() == loggedInUser.getUserId()) {
//			return cDao.save(customer);
//		} else {
//			throw new CustomerException("invalid customer details, please login first!!");
//		}

        return cDao.save(customer);

    }

    @Override
    public List<Customer> allCustomer() throws CustomerException {
        List<Customer> customer = cDao.findAll();
        if (customer.size() == 0) {
            throw new CustomerException("No customer in database");
        } else {
            return customer;
        }
    }

    @Override
    public Customer deleteCustomer(Customer customer) throws CustomerException {

        Optional<Customer> getCustomer = cDao.findById(customer.getCustomerId());

        if (getCustomer.isPresent()) {

            cDao.deleteById(customer.getCustomerId());
            return getCustomer.get();
        }
        throw new CustomerException("Customer Not Found");
    }

    @Override
    public Customer viewCustomer(Integer cid) throws CustomerException {

        Optional<Customer> findCus = cDao.findById(cid);

        if (findCus.isPresent()) {
            return findCus.get();
        } else {
            throw new CustomerException("Customer not avalible with Id: " + cid);
        }
    }

    @Override
    public Customer deleteCustomerById(Integer id) throws CustomerException {
        Optional<Customer> getCustomer = cDao.findById(id);

        if (getCustomer.isPresent()) {

            cDao.deleteById(id);
            return getCustomer.get();
        }
        throw new CustomerException("Customer Not Found with Id: "+id);
    }

}