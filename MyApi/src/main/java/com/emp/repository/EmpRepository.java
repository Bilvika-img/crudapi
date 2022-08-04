package com.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emp.entities.Employee;

public interface EmpRepository extends JpaRepository<Employee, Long>{

}
