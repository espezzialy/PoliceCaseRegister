package com.company.network;

import com.company.data.MockedData;
import com.company.model.Vehicle;
import com.company.model.types.CarType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LocalCorePanel implements InterfaceCorePanel {


    @Override
    public List<Vehicle> retornaVeiculos(Map<CarType, Integer> preferences, List<Vehicle> availableList) {
        List<Vehicle> vehicles = new ArrayList<>();

        if(preferences.containsKey(CarType.ANY)) {
            int count = preferences.get(CarType.ANY);
            for(int innerCount = 0; innerCount < count; innerCount++){
                vehicles.add(availableList.get(innerCount));

            }
            return vehicles;
        }

        if(preferences.containsKey(CarType.CARRO)) {
            int count = preferences.get(CarType.CARRO);
            for(int innerCount = 0; innerCount < availableList.size(); count++){
                if(vehicles.size() < count) {
                    if (availableList.get(innerCount).getCarType() == CarType.CARRO) {
                        vehicles.add(availableList.get(innerCount));
                    }
                }
            }
            return vehicles;
        }

        if(preferences.containsKey(CarType.CAMBURAO)) {
            int count = preferences.get(CarType.CAMBURAO);
            for(int innerCount = 0; innerCount < availableList.size(); count++){
                if(vehicles.size() < count) {
                    if (availableList.get(innerCount).getCarType() == CarType.CAMBURAO) {
                        vehicles.add(availableList.get(innerCount));
                    }
                }
            }
            return vehicles;
        }

        if(preferences.containsKey(CarType.MOTO)) {
            int count = preferences.get(CarType.MOTO);
            for(int innerCount = 0; innerCount < availableList.size(); count++){
                if(vehicles.size() < count) {
                    if (availableList.get(innerCount).getCarType() == CarType.MOTO) {
                        vehicles.add(availableList.get(innerCount));
                    }
                }
            }
            return vehicles;
        }

        return vehicles;
    }



    @Override
    public List<Vehicle> retornaVeiculosOrdenadosPorDistancia(List<Vehicle> vehicles) {
        //TODO Implementar logica para fazer uma lista real de veiculos ordenados por distancia
        return MockedData.getInstance().getCars();
    }

    @Override
    public String retornaTempo(String startPoint, String endPoint) {
        String result = "25";
        if(startPoint.equals("31585260")) {
            switch (endPoint) {
                case "31585300" -> result = "3";
                case "31585310" -> result = "5";
                case "31585320" -> result = "7";
                case "31585330" -> result = "2";
                case "31585340" -> result = "4";
                case "31585350" -> result = "6";
                case "31585360" -> result = "5";
                case "31585370" -> result = "9";
                case "31585380" -> result = "13";
                case "31585390" -> result = "11";
                default -> result = "20";
            }

        } else if (startPoint.equals("31585250")) {
            switch (endPoint) {
            case "31585300" -> result = "1";
            case "31585310" -> result = "2";
            case "31585320" -> result = "3";
            case "31585330" -> result = "3";
            case "31585340" -> result = "2";
            case "31585350" -> result = "1";
            case "31585360" -> result = "5";
            case "31585370" -> result = "6";
            case "31585380" -> result = "3";
            case "31585390" -> result = "17";
            default -> result = "20";
            }
        }
        return result;
    }

    @Override
    public String retornaDistancia(String startPoint, String endPoint) {
        String result = "25";
        if(startPoint.equals("31585260")) {
            switch (endPoint) {
                case "31585300" -> result = "3Km";
                case "31585310" -> result = "5Km";
                case "31585320" -> result = "7Km";
                case "31585330" -> result = "2Km";
                case "31585340" -> result = "4Km";
                case "31585350" -> result = "6Km";
                case "31585360" -> result = "10Km";
                case "31585370" -> result = "9Km";
                case "31585380" -> result = "13Km";
                case "31585390" -> result = "11Km";
                default -> result = "20KM";
            }

        } else if (startPoint.equals("31585250")) {
            switch (endPoint) {
                case "31585300" -> result = "1Km";
                case "31585310" -> result = "2Km";
                case "31585320" -> result = "3Km";
                case "31585330" -> result = "4Km";
                case "31585340" -> result = "5Km";
                case "31585350" -> result = "7Km";
                case "31585360" -> result = "5.5Km";
                case "31585370" -> result = "6.1Km";
                case "31585380" -> result = "3.3Km";
                case "31585390" -> result = "17Km";
                default -> result = "20Km";
            }
        }
        return result;
    }
}
