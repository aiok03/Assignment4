package com.company;

import com.company.data.PostgresDB;
import com.company.data.interfaces.IDB;
import com.company.entities.Employee;
import com.company.repositories.EmployeeRepository;
import com.company.repositories.IEmployeeRepository;
import com.company.repositories.ProjectRepository;
import com.company.repositories.IProjectRepository;

public class Main {

    public static void main(String[] args) {   //executing console app
        IDB db = new PostgresDB();
        IEmployeeRepository repo = new EmployeeRepository(db);
        IProjectRepository repo1 = new ProjectRepository(db);
        Application app = new Application(repo,repo1);

        app.start();

    }
}
