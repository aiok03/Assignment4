package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Employee;
import com.company.entities.Project;

import java.sql.Connection;
import java.util.ArrayList;


public class ProjectRepository implements IProjectRepository {
    private final IDB db;
    private ArrayList<Employee> employeeList;  //list of participated employees
    private ArrayList<Project> projectList;     //list of projects

    public ProjectRepository(IDB db) {
        this.db = db;
    }

    @Override
    public void createProject(Project project) {
        projectList = new ArrayList<Project>();
        employeeList = project.getEmployeeList();
        projectList.add(project);
    }

    @Override
    public void addEmployee(Employee employee) {
        Connection con = null;
        employeeList.add(employee);
    }

    @Override
    public int totalCost() {

        int sum = 0;
        for (int i = 0; i < employeeList.size(); i++) {
            sum += employeeList.get(i).getSalary();   //add salary of participated employees
        }
        return sum;
    }

    @Override
    public Project getProject(Project project) {
        if(projectList.contains(project)){   //check if project is exists
            return project;
        }
        return null;
    }

    @Override
    public ArrayList<Project> getAllProjects() {
        return projectList;
    }
}
