import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class PokemonServiceTest {
    private PokemonService service;

    @BeforeEach
    void setUp() {
        service = new PokemonService(new HashMapStrategy());
        service.addPokemon(new Pokemon("Pikachu", "Electric", "", "Static"));
    }

    @Test
    void testAddPokemon() {
        service.addPokemon(new Pokemon("Charmander", "Fire", "", "Blaze"));
        assertNotNull(service.getPokemon("Charmander"));
    }

    @Test
    void testGetPokemon() {
        assertNotNull(service.getPokemon("Pikachu"));
        assertNull(service.getPokemon("Mewtwo"));
    }
}