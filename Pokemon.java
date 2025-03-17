import java.io.*;
import java.util.*;

// Modelo para representar un Pokémon
public class Pokemon {
    private String name;
    private String type1;
    private String type2;
    private String ability;

    public Pokemon(String name, String type1, String type2, String ability) {
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.ability = ability;
    }

    public String getName() { return name; }
    public String getType1() { return type1; }
    public String getType2() { return type2; }
    public String getAbility() { return ability; }

    @Override
    public String toString() {
        return name + " [Type1: " + type1 + ", Type2: " + type2 + ", Ability: " + ability + "]";
    }
}