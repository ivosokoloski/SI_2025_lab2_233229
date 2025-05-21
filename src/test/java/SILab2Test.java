import org.example.Item;
import org.example.SILab2;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {

    @Test
    public void testStatement() {
        RuntimeException ex = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(null, "9876543210987654"));
        assertEquals("allItems list can't be null!", ex.getMessage());

        Item first = new Item(null, 2, 120, 0);
        ex = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(List.of(first), "9876543210987654"));
        assertEquals("Invalid item!", ex.getMessage());

        Item second = new Item("p", 1, 450, 0.15);
        double res = SILab2.checkCart(List.of(second), "9876543210987654");
        assertEquals(382.5, res);

        Item third = new Item("c", 3, 70, 0);
        res = SILab2.checkCart(List.of(third), "9876543210987654");
        assertEquals(210.0, res);
    }

    @Test
    public void testBranch() {
        Item first = new Item("z", 1, 180, 0);
        RuntimeException ex = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(List.of(first), null));
        assertEquals("Invalid card number!", ex.getMessage());

        ex = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(List.of(first), "1234"));
        assertEquals("Invalid card number!", ex.getMessage());

        ex = assertThrows(RuntimeException.class, () ->
                SILab2.checkCart(List.of(first), "1234567890123XYZ"));
        assertEquals("Invalid character in card number!", ex.getMessage());

        Item second = new Item("k", 1, 110, 0.3);
        double res = SILab2.checkCart(List.of(second), "1111222233334444");
        assertEquals(47.0, res);
    }
}
