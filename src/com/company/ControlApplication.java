package com.company;

import com.company.data.MockedData;
import com.company.panel.Panel;

public class ControlApplication {

    public static void main(String[] args) {
        MockedData.getInstance().fillMockData();
        Panel panel = new Panel();
        panel.start();

    }
}
