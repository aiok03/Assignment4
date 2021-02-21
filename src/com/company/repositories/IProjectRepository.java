package com.company.repositories;


import com.company.entities.Employee;
import com.company.entities.Project;

import java.util.ArrayList;

public interface IProjectRepository {   //interface with methods for ProjectRepository
    void createProject(Project project);   //interface method(does not have body) that create project
    void addEmployee(Employee employee);  //add employee to project
    int totalCost();    //method to count total cost of project for one month
    Project getProject(Project project);   //method to return project if it exists
    ArrayList <Project> getAllProjects();  //method to get all projects


}
