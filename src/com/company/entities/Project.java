package com.company.entities;

import java.util.ArrayList;

public class Project {
    private int id;     //Project has id, name, total cost of project and array list to collect all needed employees
    private String name;
    private int totalCost;
    private ArrayList<Employee> employeeList;
    private int id_gen=0;
    //constructors;getters and setter for all fields
    public Project(){
        id_gen++;
    }

    public Project(String name, ArrayList<Employee> employeeList) {
        setName(name);
        setEmployeeList(employeeList);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public void setEmployeeList(ArrayList<Employee> employeeList) {
        this.employeeList = employeeList;
    }
    //method toString from class Object
    @Override
    public String toString(){
        return "Project| "+name+" Total cost: "+totalCost;
    }
}
