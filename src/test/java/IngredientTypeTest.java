import org.junit.jupiter.api.Test;
import praktikum.IngredientType;

import static org.junit.jupiter.api.Assertions.*;

public class IngredientTypeTest {

    @Test
    public void testInvalidValueOf() {
        try {
            IngredientType.valueOf("INVALID_TYPE");

            fail("Ожидаемое исключение не было выброшено");
        } catch (Exception e) {

            assertEquals(IllegalArgumentException.class, e.getClass());
        }
    }
}
