package com.epam.entity;

import java.sql.Date;

public class CrewManAdmission {
    int id;
    private Date date;
    private int crew_man_id;
    private int is_admitted;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CrewManAdmission)) return false;

        CrewManAdmission that = (CrewManAdmission) o;

        if (id != that.id) return false;
        if (crew_man_id != that.crew_man_id) return false;
        if (is_admitted != that.is_admitted) return false;
        return date != null ? date.equals(that.date) : that.date == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + crew_man_id;
        result = 31 * result + is_admitted;
        return result;
    }

    @Override
    public String toString() {
        return "Crew_Man_Admission{" +
                "id=" + id +
                ", date=" + date +
                ", crew_man_id=" + crew_man_id +
                ", is_admitted=" + is_admitted +
                '}';
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

    public int getCrew_man_id() {
        return crew_man_id;
    }

    public void setCrew_man_id(int crew_man_id) {
        this.crew_man_id = crew_man_id;
    }

    public int getIs_admitted() {
        return is_admitted;
    }

    public void setIs_admitted(int is_admitted) {
        this.is_admitted = is_admitted;
    }
}
