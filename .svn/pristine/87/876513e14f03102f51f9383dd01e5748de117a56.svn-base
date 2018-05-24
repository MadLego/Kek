package com.epam.entity;

public class Plane {
    int id;
    int model_id;
    String boarding_number;
    int age;

    @Override
    public String toString() {
        return "Plane{" +
                "id=" + id +
                ", model_id=" + model_id +
                ", boarding_number='" + boarding_number + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plane)) return false;

        Plane plane = (Plane) o;

        if (id != plane.id) return false;
        if (model_id != plane.model_id) return false;
        if (age != plane.age) return false;
        return boarding_number != null ? boarding_number.equals(plane.boarding_number) : plane.boarding_number == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + model_id;
        result = 31 * result + (boarding_number != null ? boarding_number.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getModel_id() {
        return model_id;
    }

    public void setModel_id(int model_id) {
        this.model_id = model_id;
    }

    public String getBoarding_number() {
        return boarding_number;
    }

    public void setBoarding_number(String boarding_number) {
        this.boarding_number = boarding_number;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
