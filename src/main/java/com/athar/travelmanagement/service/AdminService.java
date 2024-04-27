package com.athar.travelmanagement.service;


import com.athar.travelmanagement.exception.AdminException;
import com.athar.travelmanagement.exception.ReportException;
import com.athar.travelmanagement.model.Admin;
import com.athar.travelmanagement.model.Report;

import java.util.List;

public interface AdminService {

    public List<Report> viewAllReports() throws ReportException;

    public Admin addAdmin(Admin admin) throws AdminException;

}