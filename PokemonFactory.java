public class PokemonFactory {
    public static MapStrategy getMapStrategy(int option) {
        return switch (option) {
            case 1 -> new HashMapStrategy();
            case 2 -> new TreeMapStrategy();
            case 3 -> new LinkedHashMapStrategy();
            default -> throw new IllegalArgumentException("Opción inválida");
        };
    }
}