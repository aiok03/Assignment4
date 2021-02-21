package com.company.controllers;
import com.company.entities.Employee;

import com.company.repositories.IEmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class EmployeeController {
    private final IEmployeeRepository repo;
    public EmployeeController(IEmployeeRepository repo){
        this.repo=repo;
    }
    public String createEmployee(String name, String surname, String position, int salary) {
        Employee employee=new Employee(name,surname,position,salary);


        boolean created = repo.createEmployee(employee);

        return (created ? "Employee creation was failed!" : "Employee was created!");
    }

    public String getEmployee(int id) {
        Employee employee = repo.getEmployee(id);

        return (employee == null ? "Employee was not found!" : employee.toString());
    }

    public String getAllEmployees() {
        List<Employee> employees = repo.getAllEmployees();
        return employees.toString();
    }
    public ArrayList<Employee> getAllEmployeesList(){

        return (ArrayList<Employee>) repo.getAllEmployees();
    }



}
