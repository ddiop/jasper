package com.diop.jasper.service;

import com.diop.jasper.domain.Employee;
import com.diop.jasper.repository.EmployeeRepository;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeReportService {

    @Value("${report.path}")
    private String reportPath;
    @Autowired
    private EmployeeRepository employeeRepository;

    public String generateReport() {
        Employee emp = Employee.builder().designation("france").name("djibi").oraganization("DEME consulting").salary(7000).build();
        employeeRepository.saveAndFlush(emp);

        List<Employee> employees = employeeRepository.findAll();

        try {

            File file = ResourceUtils.getFile("classpath:EmployeeReport.jrxml");

            InputStream input = new FileInputStream(file);

            // Compile the Jasper report from .jrxml to .japser

            JasperReport jasperReport = JasperCompileManager.compileReport(input);

            // Get your data source

            JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(employees);

            // Add parameters

            Map<String, Object> parameters = new HashMap<>();

            parameters.put("createdBy", "JavaHelper.org");

            // Fill the report

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, source);

            // Export the report to a PDF file

            JasperExportManager.exportReportToPdfFile(jasperPrint, reportPath + "Employee.pdf");

            System.out.println("PDF File Generated !!");


            return "Report successfully generated @path= " + reportPath;

        } catch (Exception e) {

            return e.getMessage();

        }

    }


}

