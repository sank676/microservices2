package com.UST.employeeDocker.repository;

import com.UST.employeeDocker.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Employeerepo extends JpaRepository<Employee,Integer> {

    Employee findByemployeeId(String employeeId);

    void deleteByemployeeId(String employeeId);
}
