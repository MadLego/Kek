package com.epam.entity;

public class CrewMan {
    int id;
    private String firstName;
    private String lastName;
    private int age;
    private int isPermitted;
    private String isPermittedView;
    private String role;


    public String getIsPermittedView() {
        return isPermittedView;
    }

    public void setIsPermittedView(String isPermittedView) {
        this.isPermittedView = isPermittedView;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getIsPermitted() {
        return isPermitted;
    }

    public void setIsPermitted(int isPermitted) {
        this.isPermitted = isPermitted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CrewMan)) return false;

        CrewMan crewMan = (CrewMan) o;

        if (id != crewMan.id) return false;
        if (age != crewMan.age) return false;
        if (isPermitted != crewMan.isPermitted) return false;
        if (firstName != null ? !firstName.equals(crewMan.firstName) : crewMan.firstName != null) return false;
        if (lastName != null ? !lastName.equals(crewMan.lastName) : crewMan.lastName != null) return false;
        return role != null ? role.equals(crewMan.role) : crewMan.role == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + (int) isPermitted;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CrewMan{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", isPermitted=" + isPermitted +
                ", role='" + role + '\'' +
                '}';
    }
}