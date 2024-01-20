package org.example.part3;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Inventory {

    private List<Guitar> guitars;

    public Inventory() {
        this.guitars = new ArrayList<>();
    }

    public void addGuitar(String serialNumber, double price, String builder, String model, String type, String backWood, String topWood) {
        Guitar guitar = new Guitar(serialNumber, price, builder, model, type, backWood, topWood);
        guitars.add(guitar);
        saveToFile(guitar);
    }

    public Guitar getGuitar(String serialNumber) {
        for (Guitar guitar : guitars) {
            if (guitar.getSerialNumber().equals(serialNumber)) {
                return guitar;
            }
        }
        return null;
    }

    public Guitar search(String serialNumber) {
        return getGuitar(serialNumber);
    }

    public List<Guitar> getGuitars() {
        System.out.println(guitars);
        return guitars;
    }

    private void saveToFile(Guitar guitar) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("guitar_inventory.txt", true))) {
            writer.println(guitar.getSerialNumber() + "," + guitar.getPrice() + "," + guitar.getBuilder() + ","
                    + guitar.getModel() + "," + guitar.getType() + "," + guitar.getBackWood() + "," + guitar.getTopWood());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



