package com.athar.travelmanagement.service;

import com.athar.travelmanagement.exception.ReportException;
import com.athar.travelmanagement.model.Report;

import java.util.List;

public interface ReportService {

    public Report addReport(Report report) throws ReportException;

    public Report deleteReport(Integer reportId) throws ReportException;

    public Report findByReportId(Integer reportId) throws ReportException;

    public List<Report> viewAllReports() throws ReportException;

}