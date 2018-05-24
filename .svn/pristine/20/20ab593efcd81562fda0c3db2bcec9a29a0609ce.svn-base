package com.epam.entity;

import java.sql.Date;

public class Plane_Admission {
    int id;
    Date date;
    int plane_id;
    int is_permitted;

    @Override
    public String toString() {
        return "Plane_Admission{" +
                "id=" + id +
                ", date=" + date +
                ", plane_id=" + plane_id +
                ", is_permitted=" + is_permitted +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plane_Admission)) return false;

        Plane_Admission that = (Plane_Admission) o;

        if (id != that.id) return false;
        if (plane_id != that.plane_id) return false;
        if (is_permitted != that.is_permitted) return false;
        return date != null ? date.equals(that.date) : that.date == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + plane_id;
        result = 31 * result + is_permitted;
        return result;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPlane_id() {
        return plane_id;
    }

    public void setPlane_id(int plane_id) {
        this.plane_id = plane_id;
    }

    public int getIs_permitted() {
        return is_permitted;
    }

    public void setIs_permitted(int is_permitted) {
        this.is_permitted = is_permitted;
    }
}
