package org.example;

import org.example.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        //init with default
        Employee employee = new Employee();
        EmployeeCard employeeCard = new EmployeeCard();
        Innovation innovation1 = new Innovation();
        Innovation innovation2 = new Innovation();
        List<Innovation> innovations = new ArrayList<>();
        Course course = new Course();
        Project project1 = new Project();
        Project project2 = new Project();
        Set<Project> projects = new HashSet<>();
        //init EmployeeID
        employee.setEmployeeId(1);
        //Mapping EmployeeCard Values - OneTOOne
        employeeCard.setEmployeeCardId(1);
        employeeCard.setEmployeeName("Chellamuthu");
        employeeCard.setEmployeeMailID("chellamuthupalanichamy8192@gmail.com");
        employee.setEmployeeCard(employeeCard);

        //Mapping Innovations - OneToMany
        innovation1.setInnovationId(1);
        innovation1.setInnovationName("Innov1");
        innovations.add(innovation1);
        innovation1.setInnovationId(2);
        innovation1.setInnovationName("Innov2");
        innovations.add(innovation2);
        employee.setInnovations(innovations);

        //Course - Employee Mapper - ManyTOOne
        course.setCourseId(1);
        course.setCourseName("ComputerScience");
        course.setEmployee(employee);

        //Employee Project Mapper - ManyToMany
        project1.setProjectId(1);
        project1.setProjectName("GWPolicyCenter");
        project2.setProjectId(2);
        project2.setProjectName("GWClaimCenter");
        employee.setProjects(projects);
        //Hibernate Configuration
        Configuration cfg = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(EmployeeCard.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Innovation.class)
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Project.class);
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(employeeCard);
        session.save(project1);
        session.save(project2);
        session.save(innovation1);
        session.save(innovation1);
        session.save(employee);
        session.save(course);
        tx.commit();
        session.close();
    }
}
