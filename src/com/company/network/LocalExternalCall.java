package com.company.network;

public class LocalExternalCall implements ExternalCall{
    @Override
    public String callFirefighters(boolean isNeeded) {
        if(isNeeded) {
            return ("Os bombeiros ja foram chamados e estarão a caminho.");
        } else return "";
    }

    @Override
    public String callParamedical(boolean isNeeded) {
        if(isNeeded) {
            return ("Os paramédicos ja foram chamados e estarão a caminho.");
        } else return "";
    }
}
