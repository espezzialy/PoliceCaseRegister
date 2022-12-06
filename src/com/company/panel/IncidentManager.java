package com.company.panel;

import com.company.model.Incident;

public class IncidentManager extends Panel {

    public IncidentManager(){};

    public void incidentLister() {
        for(int count=0; count < mockedData.getIncidents().size(); count++){
            Incident incident = mockedData.getIncidents().get(count);
                line = """
                       Incidente : %s
                       Descrição : %s
                       Gravidade : %s  
                       Endereço  : %s
                       """;
                printMessage(line.formatted(
                        count,
                        incident.getShortDescription(),
                        incident.getIncidentType().name(),
                        incident.getLocalization()));
            }

        startMenu();
    }

    public void incidentRemover() {
        line = """
                Bem vindo ao Removedor de Incidente
                Digite 1 para remover algum incidente
                Digite 2 para voltar para o menu principal
                
                Digite a opção desejada
                """;
        printMessage(line);
        optionSelected = scanner.nextLine();
        switch(optionSelected) {
            case "1" -> mockedDataIncidentRemover();
            case "2" -> startMenu();
            default -> endSession();
        }
    }

    private void mockedDataIncidentRemover() {
        printMessage("Digite o CEP do incidente que deseja remover");
        optionSelected = scanner.nextLine();

        for(int count=0; count < mockedData.getIncidents().size(); count++){
            Incident incidentLocalization = mockedData.getIncidents().get(count);
            if (optionSelected.equals(incidentLocalization.getLocalization())) {
               line = """
                       
                       Incidente: %s
                       Endereço : %s
                       Descrição: %s
                       
                       Digite 1 para REMOVER
                       Digite 0 para CANCELAR
                       """;
               printMessage(line.formatted(
                       count,
                       incidentLocalization.getLocalization(),
                       incidentLocalization.getShortDescription()));
               optionSelected = scanner.nextLine();
                if ("1".equals(optionSelected)) {
                    mockedData.getIncidents().remove(incidentLocalization);
                    startMenu();
                } else {
                    endSession();
                }
            } else {
                line = """
                       Nenhum Incidente encontrado utilizando este CEP
                       
                       Voltando para o Menu de remoção de incidentes.
                       
                       """;

                printMessage(line);
                incidentRemover();
            }
        }
    }
}
