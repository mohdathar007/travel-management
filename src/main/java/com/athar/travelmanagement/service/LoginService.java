package com.athar.travelmanagement.service;

import com.athar.travelmanagement.exception.LoginException;
import com.athar.travelmanagement.model.LoginDTO;

public interface LoginService {

    public String logIntoAccount(LoginDTO dto) throws LoginException;

    public String logOutFromAccount(String key) throws LoginException;
}