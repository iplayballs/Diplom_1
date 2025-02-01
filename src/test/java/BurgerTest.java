import org.junit.jupiter.api.*;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BurgerTest {

    private Burger burger;
    private Bun mockBun;
    private Ingredient mockSauce;
    private Ingredient mockFilling;

    @BeforeEach
    public void setUp() {

        burger = new Burger();
        mockBun = mock(Bun.class);
        mockSauce = mock(Ingredient.class);
        mockFilling = mock(Ingredient.class);

        when(mockBun.getPrice()).thenReturn(100f);
        when(mockBun.getName()).thenReturn("black bun");

        when(mockSauce.getPrice()).thenReturn(100f);
        when(mockSauce.getType()).thenReturn(IngredientType.SAUCE);
        when(mockSauce.getName()).thenReturn("hot sauce");

        when(mockFilling.getPrice()).thenReturn(300f);
        when(mockFilling.getType()).thenReturn(IngredientType.FILLING);
        when(mockFilling.getName()).thenReturn("sausage");
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(mockBun);

        assertEquals(mockBun, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockSauce);

        assertTrue(burger.ingredients.contains(mockSauce));
    }

    @Test
    public void testRemoveIngredient() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockFilling);
        burger.addIngredient(mockSauce);

        burger.removeIngredient(0);

        assertFalse(burger.ingredients.contains(mockFilling));
        assertTrue(burger.ingredients.contains(mockSauce));
    }

    @Test
    public void testMoveIngredient() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockSauce);
        burger.addIngredient(mockFilling);

        burger.moveIngredient(0, 1);

        assertEquals(mockFilling, burger.ingredients.get(0));
        assertEquals(mockSauce, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockSauce);
        burger.addIngredient(mockFilling);

        float expectedPrice = (100f * 2) + 100f + 300f;
        assertEquals(expectedPrice, burger.getPrice(), 0.001f);
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockSauce);
        burger.addIngredient(mockFilling);

        String expectedReceipt = "(==== black bun ====)\n" +
                "= sauce hot sauce =\n" +
                "= filling sausage =\n" +
                "(==== black bun ====)\n" +
                "\nPrice: 600,000000\n";

        assertEquals(expectedReceipt, burger.getReceipt().replaceAll("\\r", ""));
    }
}
