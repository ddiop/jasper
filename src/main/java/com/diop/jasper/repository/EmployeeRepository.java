package com.diop.jasper.repository;


import com.diop.jasper.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;



public interface EmployeeRepository extends JpaRepository<Employee, Long>{


}
