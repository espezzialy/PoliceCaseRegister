package com.company.panel;

import com.company.model.Incident;
import com.company.model.Vehicle;
import com.company.model.types.CarType;
import com.company.model.types.IncidentType;

import java.util.Map;

public class IncidentCreator extends Panel{

    public IncidentCreator(){};

    public void incidentReporter() {
        Incident incident = reportIncident();
        Map<CarType, Integer> incidentVehiclePreference = incident.getVehiclePreference();
        incident.setListOfVehicles(mockedData.localCorePanel.retornaVeiculos(incidentVehiclePreference, mockedData.getCars()));
        mockedData.setIncidents(incident);
        line = """
                Incidente Reportado!
                
                Segue abaixo lista de viatura(s) que irão atender o chamado.
                """;

        separateScreen();
        printMessage(line);
        incidentVehiclePrinter(incident);
        separateScreen();
        incidentExternalPrinter(incident);

        separateScreen();

        printMessage("Obrigado por utilizar o Sistema! \n Voltando ao Menu!");

        separateScreen();

        startMenu();

    }
    private void incidentExternalPrinter(Incident incident){
        String message = mockedData.localExternalCall.callFirefighters(incident.isFirefightersNeeded());
        printMessage(message);
        message = mockedData.localExternalCall.callParamedical(incident.isAmbulanceNeeded());
        printMessage(message);
    }
    private void incidentVehiclePrinter(Incident incident) {
        for(int count = 0; count < incident.getListOfVehicles().size(); count ++) {
            Vehicle vehicle = incident.getListOfVehicles().get(count);

            line = """
                        - Viatura número %s:
                          Tipo: %s,
                          Encontra-se a %s de distância,
                          E demorará aproximadamente %s minutos para chegar
                    """;

            printMessage(line.formatted(
                    vehicle.getId(),
                    vehicle.getCarType().name(),
                    mockedData.localCorePanel.retornaDistancia(incident.getLocalization(), vehicle.getLocalization()),
                    mockedData.localCorePanel.retornaTempo(incident.getLocalization(), vehicle.getLocalization())
            ));

        }
    }
    private Incident reportIncident() {
        Incident incident = new Incident();
        separateScreen();
        printMessage("Digite o CEP (formato XXXXXXXX) que o incidente ocorreu:");
        optionSelected = scanner.nextLine();

        // Valida formato do CEP, caso invalido pede cep novamente
        if (incident.validaCep(optionSelected)) {
            incident.setLocalization(optionSelected);
        } else {
            printMessage("CEP inválido");
            reportIncident();
        }

        printMessage("Descrição curta do ocorrido:");
        optionSelected = scanner.nextLine();
        incident.setShortDescription(optionSelected);

        line = """
                \t\t\t\t Tipo Incidente 
                Digite 1 para LEVE
                Digite 2 para MÉDIO
                Digite 3 para GRAVE
                Digite 4 para URGENTE
                Insira a opção desejada: 
                """;

        printMessage(line);
        optionSelected = scanner.nextLine();
        switch(optionSelected) {
            case "1" -> incident.setIncidentType(IncidentType.LEVE);
            case "2" -> incident.setIncidentType(IncidentType.MEDIO);
            case "3" -> incident.setIncidentType(IncidentType.GRAVE);
            case "4" -> incident.setIncidentType(IncidentType.URGENTE);
            default -> endSession();
        }

        line = """
                \t\t\t\t Local perigoso? 
                Digite 1 para SIM
                Digite 2 para NAO
                Insira a opção desejada: 
                """;

        printMessage(line);
        optionSelected = scanner.nextLine();
        switch(optionSelected) {
            case "1" -> incident.setDangerousPlace(true);
            case "2" -> incident.setDangerousPlace(false);
            default -> endSession();
        }

        line = """
                \t\t\t\t Paramédicos Necessarios? 
                Digite 1 para SIM
                Digite 2 para NAO
                Insira a opção desejada: 
                """;

        printMessage(line);
        optionSelected = scanner.nextLine();
        switch(optionSelected) {
            case "1" -> incident.setAmbulanceNeeded(true);
            case "2" -> incident.setAmbulanceNeeded(false);
            default -> endSession();
        }

        line = """
                \t\t\t\t Bombeiros necessarios? 
                Digite 1 para SIM
                Digite 2 para NAO
                Insira a opção desejada: 
                """;

        printMessage(line);
        optionSelected = scanner.nextLine();
        switch(optionSelected) {
            case "1" -> incident.setFirefightersNeeded(true);
            case "2" -> incident.setFirefightersNeeded(false);
            default -> endSession();
        }
        return incident;
    }
}
