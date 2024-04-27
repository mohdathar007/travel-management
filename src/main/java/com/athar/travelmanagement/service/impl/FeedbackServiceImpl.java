package com.athar.travelmanagement.service.impl;

import com.athar.travelmanagement.exception.CustomerException;
import com.athar.travelmanagement.exception.FeedbackException;
import com.athar.travelmanagement.model.Customer;
import com.athar.travelmanagement.model.Feedback;
import com.athar.travelmanagement.repository.CustomerDAO;
import com.athar.travelmanagement.repository.FeedbackDAO;
import com.athar.travelmanagement.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackDAO feedbackDao;

    @Autowired
    private CustomerDAO customerDao;

    @Override
    public Feedback addFeedback(Feedback feedback, Integer customerId) throws FeedbackException, CustomerException {
        Optional<Customer> findedCustomer = customerDao.findById(customerId);

        if (findedCustomer.isPresent()) {

            Customer cus = findedCustomer.get();

            feedback.setSubmitDate(LocalDate.now());

            cus.getFeedbackList().add(feedback);

            return feedbackDao.save(feedback);


        } else {
            throw new CustomerException("Customer is Not avalible By Id: " + customerId);
        }

    }

    @Override
    public Feedback findByFeeedbackId(Integer feedbackId) throws FeedbackException {
        Optional<Feedback> opt = feedbackDao.findById(feedbackId);
        if (opt.isPresent()) {
            throw new FeedbackException("Feedback does not exists with Feedback Id : " + feedbackId);
        }
        return opt.get();
    }

    @Override
    public List<Feedback> findByCustomerId(Integer customerId) throws FeedbackException, CustomerException {

        Optional<Customer> findedCust = customerDao.findById(customerId);
        if (findedCust.isPresent()) {

            Customer cus = findedCust.get();
            List<Feedback> cfidfect = cus.getFeedbackList();
            if (cfidfect.size() > 0) {
                return cfidfect;
            } else {
                throw new FeedbackException("No FeedBack is present By Customer Id; " + customerId);
            }

        } else
            throw new CustomerException("Customer not find by customer Id: " + customerId);

    }

    @Override
    public List<Feedback> viewAllFeedbacks() throws FeedbackException {
        List<Feedback> feedbacks = feedbackDao.findAll();
        if (feedbacks.isEmpty()) {
            throw new FeedbackException("No feedback exists.");
        }
        return feedbacks;
    }

}