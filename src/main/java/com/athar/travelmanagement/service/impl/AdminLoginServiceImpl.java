package com.athar.travelmanagement.service.impl;

import com.athar.travelmanagement.exception.LoginException;
import com.athar.travelmanagement.model.Admin;
import com.athar.travelmanagement.model.LoginDTO;
import com.athar.travelmanagement.model.currentUserSession;
import com.athar.travelmanagement.repository.AdminDAO;
import com.athar.travelmanagement.repository.SessionDAO;
import com.athar.travelmanagement.service.LoginService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AdminLoginServiceImpl implements LoginService {

    @Autowired
    private AdminDAO adminDao;
    @Autowired
    private SessionDAO sessionDao;


    @Override
    public String logIntoAccount(LoginDTO dto) throws LoginException {
        Admin exsistingCustomer = adminDao.findByMobile(dto.getMobileNo());

        if(exsistingCustomer == null) {
            throw new LoginException("please enter valid mobile number!");
        }

        Optional<currentUserSession> validAdminSessionopt = sessionDao.findById(exsistingCustomer.getAdminId());

        if(validAdminSessionopt.isPresent()) {
            throw new LoginException("user already logged in with this number!!!");
        }

        if(exsistingCustomer.getPassword().equals(dto.getPassword())){

            String key = RandomString.make(6);

            currentUserSession currentUserSession = new currentUserSession(exsistingCustomer.getAdminId(), key, LocalDateTime.now());

            sessionDao.save(currentUserSession);
            return currentUserSession.toString();

        }else {
            throw new LoginException("Please enter valid password!!");
        }
    }

    @Override
    public String logOutFromAccount(String key) throws LoginException {
        currentUserSession validAdminSession = sessionDao.findByUuid(key);

        if(validAdminSession == null) {
            throw new LoginException("user not logged in with this number");
        }

        sessionDao.delete(validAdminSession);

        return "Logged Out !";
    }

}