package com.athar.travelmanagement.service;

import com.athar.travelmanagement.exception.CustomerException;
import com.athar.travelmanagement.exception.FeedbackException;
import com.athar.travelmanagement.model.Feedback;

import java.util.List;

public interface FeedbackService {

    public Feedback addFeedback(Feedback feedback, Integer customerId) throws FeedbackException,CustomerException;

    public Feedback findByFeeedbackId(Integer feedbackId) throws FeedbackException;

    public List<Feedback> findByCustomerId(Integer customerId) throws FeedbackException, CustomerException;

    public List<Feedback> viewAllFeedbacks() throws FeedbackException;



}