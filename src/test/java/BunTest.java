import org.junit.jupiter.api.Test;
import praktikum.Bun;

import static org.junit.jupiter.api.Assertions.*;

public class BunTest {
    @Test
    public void testBunConstructor() {

        Bun bun = new Bun("Turkish Bun", 1.5f);

        assertEquals("Turkish Bun", bun.getName());
        assertEquals(1.5f, bun.getPrice(), 0.001f);
    }
}

