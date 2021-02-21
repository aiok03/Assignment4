package com.company.repositories;
import com.company.entities.Employee;

import java.util.ArrayList;
import java.util.List;

public interface IEmployeeRepository {   //interface with methods for EmployeeRepository
     boolean createEmployee(Employee employee); //interface method(does not have body)
     Employee getEmployee(int id);
     List<Employee> getAllEmployees();


}
