package com.example.evgeniya.basiccrudapplication1;

import java.util.Objects;

public class Employee {

    public  static final String TABLE_NAME = "employee";

    public  static final String COLUMN_ID = "emp_id";
    public  static final String COLUMN_FIRSTNAME = "first_name";
    public  static final String COLUMN_LASTNAME = "last_name";
    public  static final String COLUMN_INSURED = "insured";

    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + " (" +
                    COLUMN_ID + " INTEGER, " +
                    COLUMN_FIRSTNAME + " TEXT, " +
                    COLUMN_LASTNAME + " TEXT, " +
                    COLUMN_INSURED + " INTEGER)";
    Integer id;
    String firstName;
    String lastName;
    boolean isInsured;

    public Employee(Integer id, String firstName, String lastName, boolean isInsured) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isInsured = isInsured;
    }

    public Employee() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isInsured() {
        return isInsured;
    }

    public void setInsured(boolean insured) {
        isInsured = insured;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return isInsured == employee.isInsured &&
                Objects.equals(id, employee.id) &&
                Objects.equals(firstName, employee.firstName) &&
                Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, isInsured);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isInsured=" + isInsured +
                '}';
    }
}
