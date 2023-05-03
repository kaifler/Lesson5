package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AppData {
    private String[] header;
    private int[][] data;

    // конструктор и другие методы класса

    public void save(String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(String.join(";", header));
        writer.newLine();
        for (int[] row : data) {
            writer.write(String.join(";", toStringArray(row)));
            writer.newLine();
        }
        writer.close();
    }

    public void load(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String headerLine = reader.readLine();
        header = headerLine.split(";");
        String dataLine;
        int numRows = 0;
        while ((dataLine = reader.readLine()) != null) {
            numRows++;
        }
        data = new int[numRows][header.length];
        reader.close();
        reader = new BufferedReader(new FileReader(fileName));
        reader.readLine(); // пропускаем строку заголовка
        int rowIndex = 0;
        while ((dataLine = reader.readLine()) != null) {
            String[] values = dataLine.split(";");
            for (int i = 0; i < values.length; i++) {
                data[rowIndex][i] = Integer.parseInt(values[i]);
            }
            rowIndex++;
        }
        reader.close();
    }

    private String[] toStringArray(int[] array) {
        String[] result = new String[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = Integer.toString(array[i]);
        }
        return result;
    }
}