package com.company.model;

import com.company.model.types.CarType;
import com.company.model.types.IncidentType;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Incident {

    private String localization;
    private String shortDescription;
    private IncidentType incidentType;
    private boolean dangerousPlace;
    private boolean ambulanceNeeded;
    private boolean firefightersNeeded;

    public List<Vehicle> getListOfVehicles() {
        return listOfVehicles;
    }

    public void setListOfVehicles(List<Vehicle> listOfVehicles) {
        this.listOfVehicles = listOfVehicles;
    }

    public boolean isOnCall() {
        return isOnCall;
    }

    public void setOnCall(boolean onCall) {
        isOnCall = onCall;
    }

    private List<Vehicle> listOfVehicles;
    private boolean isOnCall;

    public Incident(String localization, String shortDescription, IncidentType incidentType,
                    boolean dangerousPlace, boolean ambulanceNeeded, boolean firefightersNeeded) {
        this.localization = localization;
        this.shortDescription = shortDescription;
        this.incidentType = incidentType;
        this.ambulanceNeeded = ambulanceNeeded;
        this.dangerousPlace = dangerousPlace;
        this.firefightersNeeded = firefightersNeeded;
    }

    public Map<CarType, Integer> getVehiclePreference() {
        Map<CarType, Integer> vehiclePreferences = new HashMap<CarType, Integer>();
        if(getIncidentType() == IncidentType.LEVE && !isDangerousPlace()) {
            vehiclePreferences = Map.of(CarType.ANY, 1);
        } else if (getIncidentType() == IncidentType.LEVE && isDangerousPlace()) {
            vehiclePreferences = Map.of(CarType.CARRO, 1);
        }

        if(getIncidentType() == IncidentType.MEDIO && !isDangerousPlace()) {
            vehiclePreferences = Map.of(CarType.CARRO, 1);
        } else if (getIncidentType() == IncidentType.MEDIO && isDangerousPlace()) {
            vehiclePreferences = Map.of(CarType.ANY, 2);
        }

        if(getIncidentType() == IncidentType.GRAVE && !isDangerousPlace()) {
            vehiclePreferences = Map.of(CarType.CARRO, 2);
        } else if (getIncidentType() == IncidentType.GRAVE && isDangerousPlace()) {
            vehiclePreferences = Map.of(CarType.CAMBURAO, 2);
        }

        if(getIncidentType() == IncidentType.URGENTE && !isDangerousPlace()) {
            vehiclePreferences = Map.of(CarType.ANY, 4);
        } else if (getIncidentType() == IncidentType.URGENTE && isDangerousPlace()) {
            vehiclePreferences = Map.of(CarType.CAMBURAO, 3);
        }

        return vehiclePreferences;

    }


    public Incident() {}

    public String getLocalization() {
        return localization;
    }

    public void setLocalization(String localization) {
        this.localization = localization;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public IncidentType getIncidentType() {
        return incidentType;
    }

    public void setIncidentType(IncidentType incidentType) {
        this.incidentType = incidentType;
    }

    public boolean isDangerousPlace() {
        return dangerousPlace;
    }

    public void setDangerousPlace(boolean dangerousPlace) {
        this.dangerousPlace = dangerousPlace;
    }

    public boolean isAmbulanceNeeded() {
        return ambulanceNeeded;
    }

    public void setAmbulanceNeeded(boolean ambulanceNeeded) {
        this.ambulanceNeeded = ambulanceNeeded;
    }

    public boolean isFirefightersNeeded() {
        return firefightersNeeded;
    }

    public void setFirefightersNeeded(boolean firefightersNeeded) {
        this.firefightersNeeded = firefightersNeeded;
    }

    //valida se o numero do cep é valido
    public boolean validaCep(String cep) {
        return cep.matches("[0-9]{8}");
    }

}
