package com.athar.travelmanagement.service.impl;

import com.athar.travelmanagement.exception.AdminException;
import com.athar.travelmanagement.exception.ReportException;
import com.athar.travelmanagement.model.Admin;
import com.athar.travelmanagement.model.Report;
import com.athar.travelmanagement.repository.AdminDAO;
import com.athar.travelmanagement.repository.ReportDAO;
import com.athar.travelmanagement.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private ReportDAO reportDao;

    @Autowired
    private AdminDAO aDao;

    @Override
    public List<Report> viewAllReports() throws ReportException {
        List<Report> reports = reportDao.findAll();
        if (reports.isEmpty()) {
            throw new ReportException("No report exists.");
        }
        return reports;
    }

    @Override
    public Admin addAdmin(Admin admin) throws AdminException {

        if(admin.getMobile().equals("1234567890")&& admin.getPassword().equals("1234567890")) {
            return aDao.save(admin);

        }else {
            throw new AdminException("invalid admin credentials!!!");
        }


    }

}