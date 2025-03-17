import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PokemonTest {
    @Test
    void testPokemonCreation() {
        Pokemon p = new Pokemon("Pikachu", "Electric", "", "Static");
        assertEquals("Pikachu", p.getName());
        assertEquals("Electric", p.getType1());
        assertEquals("Static", p.getAbility());
    }
}