package com.epam.entity;

import java.sql.Timestamp;

public class Flight {
    private int id;
    private String number;
    private int planedID;
    private String plane;
    private String departure_airport;
    private int departure_airport_id;
    private Timestamp departure_time;
    private String landing_airport;

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", planedID=" + planedID +
                ", plane='" + plane + '\'' +
                ", departure_airport='" + departure_airport + '\'' +
                ", departure_airport_id=" + departure_airport_id +
                ", departure_time=" + departure_time +
                ", landing_airport='" + landing_airport + '\'' +
                ", landing_airport_id=" + landing_airport_id +
                ", landing_time=" + landing_time +
                '}';
    }

    public int getDeparture_airport_id() {
        return departure_airport_id;
    }

    public void setDeparture_airport_id(int departure_airport_id) {
        this.departure_airport_id = departure_airport_id;
    }

    public int getLanding_airport_id() {
        return landing_airport_id;
    }

    public void setLanding_airport_id(int landing_airport_id) {
        this.landing_airport_id = landing_airport_id;
    }

    private int landing_airport_id;
    private Timestamp landing_time;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDeparture_airport() {
        return departure_airport;
    }

    public void setDeparture_airport(String departure_airport) {
        this.departure_airport = departure_airport;
    }

    public Timestamp getDeparture_time() {
        return departure_time;
    }

    public void setDeparture_time(Timestamp departure_time) {
        this.departure_time = departure_time;
    }

    public Timestamp getLanding_time() {
        return landing_time;
    }

    public void setLanding_time(Timestamp landing_time) {
        this.landing_time = landing_time;
    }

    public String getLanding_airport() {
        return landing_airport;
    }

    public void setLanding_airport(String landing_airport) {
        this.landing_airport = landing_airport;
    }




    public String getPlane() {

        return plane;
    }

    public void setPlane(String plane) {
        this.plane = plane;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Flight)) return false;

        Flight flight = (Flight) o;

        if (id != flight.id) return false;
        if (number != null ? !number.equals(flight.number) : flight.number != null) return false;
        if (plane != null ? !plane.equals(flight.plane) : flight.plane != null) return false;
        if (departure_airport != null ? !departure_airport.equals(flight.departure_airport) : flight.departure_airport != null)
            return false;
        if (departure_time != null ? !departure_time.equals(flight.departure_time) : flight.departure_time != null)
            return false;
        if (landing_airport != null ? !landing_airport.equals(flight.landing_airport) : flight.landing_airport != null)
            return false;
        return landing_time != null ? landing_time.equals(flight.landing_time) : flight.landing_time == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (plane != null ? plane.hashCode() : 0);
        result = 31 * result + (departure_airport != null ? departure_airport.hashCode() : 0);
        result = 31 * result + (departure_time != null ? departure_time.hashCode() : 0);
        result = 31 * result + (landing_airport != null ? landing_airport.hashCode() : 0);
        result = 31 * result + (landing_time != null ? landing_time.hashCode() : 0);
        return result;
    }

    public int getPlanedID() {
        return planedID;
    }

    public void setPlanedID(int planedID) {
        this.planedID = planedID;
    }
}
