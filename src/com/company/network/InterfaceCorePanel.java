package com.company.network;

import com.company.model.Vehicle;
import com.company.model.types.CarType;

import java.util.List;
import java.util.Map;

public interface InterfaceCorePanel {
    public List<Vehicle> retornaVeiculos(Map<CarType, Integer> preferences, List<Vehicle> availableList);

    public List<Vehicle> retornaVeiculosOrdenadosPorDistancia(List<Vehicle> vehicles);

    public String retornaTempo(String startPoint, String endPoint);
    public String retornaDistancia(String startPoint, String endPoint);
}
