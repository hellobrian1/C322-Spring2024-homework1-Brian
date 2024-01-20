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
}
