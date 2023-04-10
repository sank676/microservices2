package com.UST.employeeDocker.controller;

import com.UST.employeeDocker.model.Employee;
import com.UST.employeeDocker.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp/registration")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addemps")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }
    @GetMapping("/Employees")
    public List<Employee> getAllEmployee(){
        return employeeService.getEmployees();
    }

    @GetMapping("/Employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable String employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @DeleteMapping("/deleteEmployee/{employeeId}")
    public String deleteEmployee(@PathVariable String employeeId) {
        return employeeService.deleteEmployeeById(employeeId);
    }

}
