package com.epam.dto;

public class EmployeeDTO {
    int id;
    String firstName;
    String lastName;
    int age;
    int isPermitter;
    String isPemittedView;
    String role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsPemittedView() {
        return isPemittedView;
    }

    public void setIsPemittedView(String isPemittedView) {
        this.isPemittedView = isPemittedView;
    }



    @Override
    public String toString() {
        return "EmployeeDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", isPermitter=" + isPermitter +
                ", role='" + role + '\'' +
                '}';
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getIsPermitter() {
        return isPermitter;
    }

    public void setIsPermitter(int isPermitter) {
        this.isPermitter = isPermitter;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
