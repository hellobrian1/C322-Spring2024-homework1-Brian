import org.example.part3.Guitar;
import org.example.part3.Inventory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GuitarTest {

    private Inventory inventory;

    @BeforeEach
    public void setUp() {
        // Create an inventory with some guitars
        inventory = new Inventory();
        inventory.addGuitar("123", 1000.0, "Fender", "Stratocruisers", "Electric", "Maple", "Alder");
        inventory.addGuitar("456", 1500.0, "Gibson", "Les Paul", "Electric", "Mahogany", "Maple");
    }

    @Test
    public void testSearchExistingGuitar() {
        // Search for an existing guitar
        Guitar foundGuitar = inventory.search("123");

        // Verify that the correct guitar is found
        assertNotNull(foundGuitar);
        assertEquals("123", foundGuitar.getSerialNumber());
        assertEquals(1000.0, foundGuitar.getPrice());
        assertEquals("Fender", foundGuitar.getBuilder());
        assertEquals("Stratocruisers", foundGuitar.getModel());
        assertEquals("Electric", foundGuitar.getType());
        assertEquals("Maple", foundGuitar.getBackWood());
        assertEquals("Alder", foundGuitar.getTopWood());
    }

    @Test
    public void testSearchNonExistingGuitar() {
        // Search for a non-existing guitar
        Guitar foundGuitar = inventory.search("789");

        // Verify that no guitar is found
        assertNull(foundGuitar);
    }



    @Test
    public void testGetGuitarFromMemory() {
        Guitar guitar = inventory.getGuitar("123");
        assertNotNull(guitar);
        assertEquals("123", guitar.getSerialNumber());
    }

    @Test
    public void testGetGuitarFromFile() {
        // Assuming "789" is a serial number that doesn't exist in memory but is in the file
        Guitar guitar = inventory.getGuitar("789");
        assertNotNull(guitar);
        assertEquals("789", guitar.getSerialNumber());
        // Add additional assertions based on the expected values in your file
        assertEquals( "Builder3", guitar.getBuilder());
        assertEquals( "Model3", guitar.getModel());
        // Add more assertions as needed
    }

    @Test
    public void testGetGuitarNotFound() {
        // Assuming "999" is a serial number that doesn't exist in memory or in the file
        Guitar guitar = inventory.getGuitar("999");
        assertNull(guitar);
    }
}
