package com.diop.jasper.controller;


import com.diop.jasper.service.EmployeeReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/employee")
public class EmpReportController {
    @Autowired
    private EmployeeReportService employeeReportService;

    @GetMapping("/report")

    public String empReport() {

        return employeeReportService.generateReport();

    }

}
