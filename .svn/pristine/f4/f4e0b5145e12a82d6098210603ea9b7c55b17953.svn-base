package com.epam.dto;

public class CrewDTO {
   private int id;
   private int flight_id;
   private int pilot;
   private int navigator;
   private int radio_operator;
   private int first_conductor;
   private int second_conductor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlight_id() {
        return flight_id;
    }

    public void setFlight_id(int flight_id) {
        this.flight_id = flight_id;
    }

    public int getPilot() {
        return pilot;
    }

    public void setPilot(int pilot) {
        this.pilot = pilot;
    }

    public int getNavigator() {
        return navigator;
    }

    public void setNavigator(int navigator) {
        this.navigator = navigator;
    }

    public int getRadio_operator() {
        return radio_operator;
    }

    public void setRadio_operator(int radio_operator) {
        this.radio_operator = radio_operator;
    }

    public int getFirst_conductor() {
        return first_conductor;
    }

    public void setFirst_conductor(int first_conductor) {
        this.first_conductor = first_conductor;
    }

    public int getSecond_conductor() {
        return second_conductor;
    }

    public void setSecond_conductor(int second_conductor) {
        this.second_conductor = second_conductor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CrewDTO)) return false;

        CrewDTO dto = (CrewDTO) o;

        if (id != dto.id) return false;
        if (flight_id != dto.flight_id) return false;
        if (pilot != dto.pilot) return false;
        if (navigator != dto.navigator) return false;
        if (radio_operator != dto.radio_operator) return false;
        if (first_conductor != dto.first_conductor) return false;
        return second_conductor == dto.second_conductor;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + flight_id;
        result = 31 * result + pilot;
        result = 31 * result + navigator;
        result = 31 * result + radio_operator;
        result = 31 * result + first_conductor;
        result = 31 * result + second_conductor;
        return result;
    }

    @Override
    public String toString() {
        return "CrewDTO{" +
                "id=" + id +
                ", flight_id=" + flight_id +
                ", pilot=" + pilot +
                ", navigator=" + navigator +
                ", radio_operator=" + radio_operator +
                ", first_conductor=" + first_conductor +
                ", second_conductor=" + second_conductor +
                '}';
    }
}
