package com.company.repositories;

import com.company.data.interfaces.IDB;
import com.company.entities.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {  //realization of methods
    private final IDB db;

    public EmployeeRepository(IDB db) {
        this.db = db;
    }
    @Override
    public boolean createEmployee(Employee employee) {
        Connection con = null;
        try {
            con = db.getConnection(); //connection with DB(database)
            String sql = "INSERT INTO employees(name,surname,position,salary) VALUES (?,?,?,?)"; /* sql statement for
                                                                                                 inserting data into
                                                                                                table employees*/
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, employee.getName());    //setting name,surname,position and salary
            st.setString(2, employee.getSurname());
            st.setString(3, employee.getPosition());
            st.setInt(4, employee.getSalary());


            boolean executed = st.execute();
            return executed;
        } catch (SQLException throwables) {   //error handling
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }
    @Override
    public Employee getEmployee(int id){
        Connection con = null;   //connection with DB(database)
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname,position,salary FROM employees WHERE id=?"; /* sql statement for
                                                                                                 selecting one employee
                                                                                                  from table employees*/
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Employee employee = new Employee(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("position"),
                        rs.getInt("salary"));


                return employee;
            }
        } catch (SQLException throwables) {    //error handling
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }
    @Override
    public List<Employee> getAllEmployees() {
        Connection con = null;
        try {
            con = db.getConnection();  //connection with DB(database)
            String sql = "SELECT id,name,surname,position,salary FROM employees";  /* sql statement for
                                                                                     selecting all employees
                                                                                   from table employees*/
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Employee> employees = new ArrayList<>();
            while (rs.next()) {
                Employee employee = new Employee(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("position"),
                        rs.getInt("salary"));

                employees.add(employee);
            }

            return employees;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }


}
