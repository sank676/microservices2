package com.UST.employeeDocker.service;


import com.UST.employeeDocker.model.Employee;
import com.UST.employeeDocker.repository.Employeerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private Employeerepo repo;

    public Employee createEmployee(Employee employee) {

        return repo.save(employee);
    }

    public java.util.List<Employee> getEmployees() {
        return repo.findAll();
    }




    public Employee getEmployeeById(String employeeId) {
        return repo.findByemployeeId(employeeId) ;
    }


@Transactional
    public String deleteEmployeeById(String employeeId) {
        repo.deleteByemployeeId(employeeId);
        return "the employee information is deleted";
    }



}