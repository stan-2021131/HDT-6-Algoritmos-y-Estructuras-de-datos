import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManejoDataTest {
    private ManejoDatos md;

    @BeforeEach
    public void init(){
        md = new ManejoDatos();
    }

    @Test
    public void testStrToPokemon(){
        String[] data = {"Vullaby","629","Dark","Flying","Diapered Pokémon","0.5","9","Big-pecks", "Overcoat", "Weak-armor","5","No"};
        Pokemon pokemon = md.strToPokemon(data);
        assertNotNull(pokemon);
        assertEquals("Vullaby", pokemon.getName());
        assertEquals(629, pokemon.getNum_Pokedex());
        assertEquals("Dark", pokemon.getType1());
        assertEquals("Flying", pokemon.getType2());
        assertEquals("Diapered Pokémon", pokemon.getClassifiaction());
        assertEquals(0.5, pokemon.getHeight());
        assertEquals(9, pokemon.getWeight());
        assertTrue(pokemon.getAbilities().contains("Big-pecks"));
        assertTrue(pokemon.getAbilities().contains("Overcoat"));
        assertTrue(pokemon.getAbilities().contains("Weak-armor"));
        assertEquals(5, pokemon.getGeneration());
        assertFalse(pokemon.getLegendary()); 
    }

    @Test
    public void testCargarPokemon() throws ClassNotFoundException{
        ClassFactory cf = new ClassFactory();
        assertNotNull(md.cargarPokemon("pokemon_data_pokeapi.csv", "TreeMap", cf));
    }
        
}
