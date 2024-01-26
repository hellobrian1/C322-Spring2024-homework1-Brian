package org.example.part3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {
    private Inventory inventory;

    @BeforeEach
    void setUp() {
        // Initialize Inventory before each test
        inventory = new Inventory();
    }

    @Test
    void addGuitar() {
        // Test adding a guitar
        inventory.addGuitar("123", 1000.0, "Fender", "Stratocaster", "Electric", "Maple", "Maple");
        assertEquals(1, inventory.getGuitars().size());
    }

    @Test
    void getGuitar() {
        // Test getting a guitar from memory
        inventory.addGuitar("123", 1000.0, "Fender", "Stratocaster", "Electric", "Maple", "Maple");
        Guitar guitar = inventory.getGuitar("123");
        assertNotNull(guitar);
        assertEquals("123", guitar.getSerialNumber());
    }

    @Test
    void getGuitarFromFile() throws IOException {
        // Test getting a guitar from file
        // Prepare test data in the file
        try (PrintWriter writer = new PrintWriter(new FileWriter("guitar_inventory.txt"))) {
            writer.println("123,1000.0,Fender,Stratocaster,Electric,Maple,Maple");
        }

        Guitar guitar = inventory.getGuitarFromFile("123");
        assertNotNull(guitar);
        assertEquals("123", guitar.getSerialNumber());

        // Clean up test data from the file
        new File("guitar_inventory.txt").delete();
    }

    @Test
    void search() {
        // Test searching for a guitar
        inventory.addGuitar("123", 1000.0, "Fender", "Stratocaster", "Electric", "Maple", "Maple");
        Guitar guitar = inventory.search("123");
        assertNotNull(guitar);
        assertEquals("123", guitar.getSerialNumber());
    }

    @Test
    void getGuitars() {
        // Test getting the list of guitars
        inventory.addGuitar("123", 1000.0, "Fender", "Stratocaster", "Electric", "Maple", "Maple");
        inventory.addGuitar("456", 1500.0, "Gibson", "Les Paul", "Electric", "Mahogany", "Maple");
        List<Guitar> guitars = inventory.getGuitars();
        assertNotNull(guitars);
        assertEquals(2, guitars.size());
    }
}
