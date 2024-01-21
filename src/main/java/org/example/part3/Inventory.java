package org.example.part3;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

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
        // First, try to find the guitar in memory
        for (Guitar guitar : guitars) {
            if (guitar.getSerialNumber().equals(serialNumber)) {
                System.out.println("Found guitar in memory");
                return guitar;
            }
        }
        // If not found in memory, try to read from the text file
        Guitar guitarFromFile = getGuitarFromFile(serialNumber);
        return guitarFromFile;
    }

    private Guitar getGuitarFromFile(String serialNumber) {
        try (BufferedReader reader = new BufferedReader(new FileReader("guitar_inventory.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] guitarData = line.split(",");
                if (guitarData.length == 7 && guitarData[0].equals(serialNumber)) {
                    // Create a new Guitar object from the file data
                    System.out.println("Found guitar in file");
                    return new Guitar(guitarData[0], Double.parseDouble(guitarData[1]),
                            guitarData[2], guitarData[3], guitarData[4], guitarData[5], guitarData[6]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        // Return null if not found in the file
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



