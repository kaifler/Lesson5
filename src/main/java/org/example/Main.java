package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        AppData appData = new AppData();
// заполнение данных
        appData.save("data.csv");

        AppData appData = new AppData();
        appData.load("data.csv");
    }
}
