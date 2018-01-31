package com.epam.entity;

public class CrewView {
   private int id;
   private String flightId;
   private String pilot;
   private String navigator;
   private String radioOperator;
   private String firstConductor;
   private String secondConductor;
   private int isPermitted;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public String getPilot() {
        return pilot;
    }

    public void setPilot(String pilot) {
        this.pilot = pilot;
    }

    public String getNavigator() {
        return navigator;
    }

    public void setNavigator(String navigator) {
        this.navigator = navigator;
    }

    public String getRadioOperator() {
        return radioOperator;
    }

    public void setRadioOperator(String radioOperator) {
        this.radioOperator = radioOperator;
    }

    public String getFirstConductor() {
        return firstConductor;
    }

    public void setFirstConductor(String firstConductor) {
        this.firstConductor = firstConductor;
    }

    public String getSecondConductor() {
        return secondConductor;
    }

    public void setSecondConductor(String secondConductor) {
        this.secondConductor = secondConductor;
    }

    public int getIsPermitted() {
        return isPermitted;
    }

    public void setIsPermitted(int isPermitted) {
        this.isPermitted = isPermitted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CrewView)) return false;

        CrewView crewView = (CrewView) o;

        if (id != crewView.id) return false;
        if (!flightId.equals(crewView.flightId)) return false;
        if (isPermitted != crewView.isPermitted) return false;
        if (pilot != null ? !pilot.equals(crewView.pilot) : crewView.pilot != null) return false;
        if (navigator != null ? !navigator.equals(crewView.navigator) : crewView.navigator != null) return false;
        if (radioOperator != null ? !radioOperator.equals(crewView.radioOperator) : crewView.radioOperator != null)
            return false;
        if (firstConductor != null ? !firstConductor.equals(crewView.firstConductor) : crewView.firstConductor != null)
            return false;
        return secondConductor != null ? secondConductor.equals(crewView.secondConductor) : crewView.secondConductor == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (flightId != null ? flightId.hashCode() : 0);
        result = 31 * result + (pilot != null ? pilot.hashCode() : 0);
        result = 31 * result + (navigator != null ? navigator.hashCode() : 0);
        result = 31 * result + (radioOperator != null ? radioOperator.hashCode() : 0);
        result = 31 * result + (firstConductor != null ? firstConductor.hashCode() : 0);
        result = 31 * result + (secondConductor != null ? secondConductor.hashCode() : 0);
        result = 31 * result + isPermitted;
        return result;
    }

    @Override
    public String toString() {
        return "CrewView{" +
                "id=" + id +
                ", flightId=" + flightId +
                ", pilot='" + pilot + '\'' +
                ", navigator='" + navigator + '\'' +
                ", radioOperator='" + radioOperator + '\'' +
                ", firstConductor='" + firstConductor + '\'' +
                ", secondConductor='" + secondConductor + '\'' +
                ", isPermitted=" + isPermitted +
                '}';
    }
}
