package com.epam.entity;

public class Plane_Model {
    int id;
    String name;
    short passangers;

    @Override
    public String   toString() {
        return "Plane_Model{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", passangers=" + passangers +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plane_Model)) return false;

        Plane_Model that = (Plane_Model) o;

        if (id != that.id) return false;
        if (passangers != that.passangers) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) passangers;
        return result;
    }

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

    public short getPassangers() {
        return passangers;
    }

    public void setPassangers(short passangers) {
        this.passangers = passangers;
    }
}
