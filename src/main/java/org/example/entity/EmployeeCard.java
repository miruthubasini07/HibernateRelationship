package org.example.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmployeeCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int EmployeeCardId;
    String EmployeeName;
    String EmployeeMailID;

    public int getEmployeeCardId() {
        return EmployeeCardId;
    }

    public void setEmployeeCardId(int employeeCardId) {
        EmployeeCardId = employeeCardId;
    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public String getEmployeeMailID() {
        return EmployeeMailID;
    }

    public void setEmployeeMailID(String employeeMailID) {
        EmployeeMailID = employeeMailID;
    }
}
