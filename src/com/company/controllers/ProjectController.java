package com.company.controllers;

import com.company.entities.Employee;
import com.company.entities.Project;
import com.company.repositories.IProjectRepository;

import java.util.ArrayList;


    public class ProjectController {
        private final IProjectRepository repo;

        public ProjectController(IProjectRepository repo) {
            this.repo = repo;
        }
        public String createProject(String name, ArrayList<Employee> employeeList){
            Project project = new Project(name,employeeList);  //create project

            return "Project created";
        }

        public String getProject(Project project){
            Project project1 = repo.getProject(project);

            return (project1 == null ? "Project didn't found" : project1.toString()); /*if project is not created return
                                                                                        that statement*/
        }

        public int totalCost(){
            return repo.totalCost();
        }  //

        public ArrayList<Project> getAllProjects(){
            ArrayList<Project> projects = repo.getAllProjects();
            return projects;
        }

        public void setProject(Project project){
            repo.createProject(project);
        }
    }

