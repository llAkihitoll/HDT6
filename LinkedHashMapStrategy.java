public class LinkedHashMapStrategy implements MapStrategy {
    public Map<String, Pokemon> createMap() {
        return new LinkedHashMap<>();
    }
}
