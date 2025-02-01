import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.ParameterizedTest;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.jupiter.api.Assertions.*;

public class IngredientTest {

    private IngredientType type;
    private String name;
    private float price;

    public static Object[][] data() {
        return new Object[][] {
                { IngredientType.SAUCE, "hot sauce", 100.0f },
                { IngredientType.SAUCE, "sour cream", 150.5f },
                { IngredientType.FILLING, "cutlet", 50.0f },
                { IngredientType.FILLING, "dinosaur", 120.5f }
        };
    }

    @ParameterizedTest
    @MethodSource("data")
    public void testIngredientDetails() {

        Ingredient ingredient = new Ingredient(type, name, price);

        assertEquals(type, ingredient.getType());
        assertEquals(name, ingredient.getName());
        assertEquals(price, ingredient.getPrice(), 0.001f);
    }
}
