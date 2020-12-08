package com.my.spring.Thymeleaf.Thymeleafdemo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.my.spring.Thymeleaf.Thymeleafdemo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
