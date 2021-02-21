package com.company.entities;

public class Employee {  //class employee
    private int id;    //employee has id,name,surname and fixed salary
    private String name;
    private String surname;
    private String position;
    private int salary;

    public Employee(){    //id will increment automatically in pgadmin,because it is serial

    }
    public Employee(int id,String name,String surname,String position,int salary){  //constructor to set info with id
        setId(id);
        setName(name);
        setSurname(surname);
        setPosition(position);
        setSalary(salary);

    }
    public Employee(String name,String surname,String position,int salary){  //without id
        setName(name);
        setSurname(surname);
        setPosition(position);
        setSalary(salary);
    }
    //getters and setter for all fields
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
    //method toString from class Object
    @Override
    public String toString(){
        return "Employee "+id+"{ Name:"+name+", Surname:"+surname+", Position:"+position+", Salary:"+salary+"} ";
    }
}