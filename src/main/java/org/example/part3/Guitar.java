package org.example.part3;
public class Guitar {
    private String serialNumber;
    private double price;
    private String builder;
    private String model;
    private String type;
    private String backWood;
    private String topWood;
    public Guitar(String serialNumber, double price, String builder, String model, String type, String backWood, String topWood) {
        this.serialNumber = serialNumber;
        this.price = price;
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
    }
    public String getSerialNumber() {
        return serialNumber;
    }
    public double getPrice() {
        return price;
    }
    public String getBuilder() {
        return builder;
    }
    public String getModel() {
        return model;
    }
    public String getType() {
        return type;
    }
    public String getBackWood() {
        return backWood;
    }
    public String getTopWood() {
        return topWood;
    }
    private static void displayInventory(Inventory inventory) {
        for (Guitar guitar : inventory.getGuitars()) {
            displayGuitar(guitar);
        }
    }

    private static void displayGuitar(Guitar guitar) {
        System.out.println("Serial Number: " + guitar.getSerialNumber());
        System.out.println("Price: $" + guitar.getPrice());
        System.out.println("Builder: " + guitar.getBuilder());
        System.out.println("Model: " + guitar.getModel());
        System.out.println("Type: " + guitar.getType());
        System.out.println("Back Wood: " + guitar.getBackWood());
        System.out.println("Top Wood: " + guitar.getTopWood());
        System.out.println("------------------------");
    }
}
