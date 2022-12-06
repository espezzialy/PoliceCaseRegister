package com.company.panel;

import com.company.commom.Colors;
import com.company.data.MockedData;

import java.util.Objects;
import java.util.Scanner;

public class Panel {

    private static final Integer SIZE_SCREEN = 76;
    private static final String EMPTY = "";

    // Variaveis globais para utilização da classe e filhos.
    Scanner scanner = new Scanner(System.in);
    protected static final MockedData mockedData = MockedData.getInstance();
    protected String optionSelected;
    protected String line;

    public void start() {
        separateScreen();
        line = """
                \t\t\t\t\t\t PoliceCaseRegister Version 1.0.0

                Seja bem-vindo ao PoliceCaseRegister, prossiga no menu abaixo para as opções no menu
                
                Pressione ESQ ou enter vazio a qualquer momento para finalizar essa sessão""";

        printMessage(line);
        separateScreen();
        startMenu();
    }

    protected void startMenu() {
        separateScreen();
        line = """
                \t\t\t\t\t\t MENU
                Digite 1 para reportar um incidente
                Digite 2 para listar todos os incidentes
                Digite 3 para cancelar um incidente
                
                Insira a opção desejada: 
                """;
        printMessage(line);

        optionSelected = scanner.nextLine();

        switch(optionSelected) {
            case "1" -> new IncidentCreator().incidentReporter();
            case "2" -> new IncidentManager().incidentLister();
            case "3" -> new IncidentManager().incidentRemover();
            default -> endSession();
        }
    }


    //Método para finalizar o sistema
    protected void endSession() {
        separateScreen();
        printMessage("Obrigado por usar o sistema!");
        separateScreen();
    }


    //Método para separar telas nas mensagens utilizadas pelo terminal
    protected void separateScreen(){
        String repeated = new String(new char[SIZE_SCREEN]).replace("\0", "-");
        printMessage(EMPTY);
        printMessage(Colors.ANSI_BLUE + repeated + Colors.ANSI_BLUE);
        printMessage(EMPTY);
    }

    //Método para evitar boilerplate de impressão
    protected void printMessage(String message){
        System.out.println(Objects.requireNonNullElse(message, ""));
    }
}
