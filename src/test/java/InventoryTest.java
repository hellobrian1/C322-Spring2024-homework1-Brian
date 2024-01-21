import org.example.part3.Guitar;
import org.example.part3.Inventory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InventoryTest {

    @Test
    public void testSearchExistingGuitar() {

        Inventory inventory = new Inventory();


        inventory.addGuitar("G123", 999.99, "Gibson", "Les Paul", "Electric", "Mahogany", "Maple");


        Guitar searchedGuitar = inventory.search("G123");


        assertNotNull(searchedGuitar);

        // Check if the details of the found guitar are correct
        assertEquals("G123", searchedGuitar.getSerialNumber());
        assertEquals(999.99, searchedGuitar.getPrice(), 0.001); // Using delta for double comparison
        assertEquals("Gibson", searchedGuitar.getBuilder());
        assertEquals("Les Paul", searchedGuitar.getModel());
        assertEquals("Electric", searchedGuitar.getType());
        assertEquals("Mahogany", searchedGuitar.getBackWood());
        assertEquals("Maple", searchedGuitar.getTopWood());
    }

    @Test
    public void testSearchNonExistingGuitar() {

        Inventory inventory = new Inventory();

        Guitar searchedGuitar = inventory.search("NonExistentSerialNumber");

        assertNull(searchedGuitar);
    }

    @Test
    public void testAddGuitar() {
        Inventory inventory = new Inventory();

        // Adding a guitar to the inventory
        inventory.addGuitar("123", 1000.0, "Builder1", "Model1", "Type1", "BackWood1", "TopWood1");

        // Retrieving the added guitar
        Guitar retrievedGuitar = inventory.getGuitar("123");

        // Asserting that the retrieved guitar is not null
        assertNotNull(retrievedGuitar);

        // Asserting that the details of the retrieved guitar match the added guitar
        assertEquals("123", retrievedGuitar.getSerialNumber());
        assertEquals(1000.0, retrievedGuitar.getPrice(), 0.001); // Using delta for double comparison
        assertEquals("Builder1", retrievedGuitar.getBuilder());
        assertEquals("Model1", retrievedGuitar.getModel());
        assertEquals("Type1", retrievedGuitar.getType());
        assertEquals("BackWood1", retrievedGuitar.getBackWood());
        assertEquals("TopWood1", retrievedGuitar.getTopWood());
    }

    @Test
    public void testGetGuitarNotFound() {
        Inventory inventory = new Inventory();

        // Attempting to retrieve a guitar that has not been added
        Guitar retrievedGuitar = inventory.getGuitar("456");

        // Asserting that the retrieved guitar is null
        assertNull(retrievedGuitar);
    }

    @Test
    public void testAddMultipleGuitars() {
        Inventory inventory = new Inventory();

        // Adding multiple guitars to the inventory
        inventory.addGuitar("123", 1000.0, "Builder1", "Model1", "Type1", "BackWood1", "TopWood1");
        inventory.addGuitar("456", 1500.0, "Builder2", "Model2", "Type2", "BackWood2", "TopWood2");
        inventory.addGuitar("789", 1200.0, "Builder3", "Model3", "Type3", "BackWood3", "TopWood3");

        // Retrieving the added guitars
        Guitar retrievedGuitar1 = inventory.getGuitar("123");
        Guitar retrievedGuitar2 = inventory.getGuitar("456");
        Guitar retrievedGuitar3 = inventory.getGuitar("789");

        // Asserting that the retrieved guitars are not null
        assertNotNull(retrievedGuitar1);
        assertNotNull(retrievedGuitar2);
        assertNotNull(retrievedGuitar3);

        // Asserting that the details of the retrieved guitars match the added guitars
        assertEquals("123", retrievedGuitar1.getSerialNumber());
        assertEquals(1000.0, retrievedGuitar1.getPrice(), 0.001);
        assertEquals("Builder1", retrievedGuitar1.getBuilder());

        assertEquals("456", retrievedGuitar2.getSerialNumber());
        assertEquals(1500.0, retrievedGuitar2.getPrice(), 0.001);
        assertEquals("Builder2", retrievedGuitar2.getBuilder());

        assertEquals("789", retrievedGuitar3.getSerialNumber());
        assertEquals(1200.0, retrievedGuitar3.getPrice(), 0.001);
        assertEquals("Builder3", retrievedGuitar3.getBuilder());
    }

    @Test
    public void testAddAndRetrieveWithSameSerialNumber() {
        Inventory inventory = new Inventory();

        // Adding a guitar to the inventory
        inventory.addGuitar("123", 1000.0, "Builder1", "Model1", "Type1", "BackWood1", "TopWood1");

        // Attempting to add another guitar with the same serial number (should not be added)
        inventory.addGuitar("123", 1500.0, "Builder2", "Model2", "Type2", "BackWood2", "TopWood2");

        // Retrieving the added guitar
        Guitar retrievedGuitar = inventory.getGuitar("123");


        // Asserting that only the first guitar is present in the inventory
        assertNotNull(retrievedGuitar);
        assertEquals("Builder1", retrievedGuitar.getBuilder());
        assertEquals(1000.0, retrievedGuitar.getPrice(), 0.001);

    }
    @Test
    void getGuitarFromFile() {
        // Arrange
        Inventory inventory = new Inventory();
        String serialNumber = "123";
        double price = 999.99;
        String builder = "Fender";
        String model = "Stratocaster";
        String type = "Electric";
        String backWood = "Maple";
        String topWood = "Alder";

        // Add a guitar to the file
        inventory.addGuitar(serialNumber, price, builder, model, type, backWood, topWood);

        // Act
        Guitar guitarFromFile = inventory.getGuitarFromFile(serialNumber);

        // Assert
        assertNotNull(guitarFromFile);
        assertEquals(serialNumber, guitarFromFile.getSerialNumber());
        assertEquals(price, guitarFromFile.getPrice());
        assertEquals(builder, guitarFromFile.getBuilder());
        assertEquals(model, guitarFromFile.getModel());
        assertEquals(type, guitarFromFile.getType());
        assertEquals(backWood, guitarFromFile.getBackWood());
        assertEquals(topWood, guitarFromFile.getTopWood());
    }


}
