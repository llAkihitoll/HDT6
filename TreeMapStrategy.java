public class TreeMapStrategy implements MapStrategy {
    public Map<String, Pokemon> createMap() {
        return new TreeMap<>();
    }
}