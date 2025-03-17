public class PokemonService {
    private Map<String, Pokemon> pokemonMap;
    private Set<String> userCollection;

    public PokemonService(MapStrategy strategy) {
        this.pokemonMap = strategy.createMap();
        this.userCollection = new HashSet<>();
        loadPokemonFromCSV("/mnt/data/extracted_pokemon_data/pokemon_data_pokeapi.csv");
    }

    public void addPokemon(Pokemon pokemon) {
        pokemonMap.putIfAbsent(pokemon.getName(), pokemon);
    }

    public void addPokemonToUserCollection(String name) {
        if (!pokemonMap.containsKey(name)) {
            System.out.println("Error: Pokémon no encontrado en la base de datos.");
            return;
        }
        if (!userCollection.add(name)) {
            System.out.println("El Pokémon ya está en tu colección.");
        } else {
            System.out.println("Pokémon agregado exitosamente a tu colección.");
        }
    }

    public Pokemon getPokemon(String name) {
        return pokemonMap.get(name);
    }

    public void listUserCollectionSortedByType1() {
        userCollection.stream()
                .map(pokemonMap::get)
                .sorted(Comparator.comparing(Pokemon::getType1))
                .forEach(System.out::println);
    }

    public void listAllSortedByType1() {
        pokemonMap.values().stream()
                .sorted(Comparator.comparing(Pokemon::getType1))
                .forEach(System.out::println);
    }

    public void listByAbility(String ability) {
        pokemonMap.values().stream()
                .filter(p -> p.getAbility().equalsIgnoreCase(ability))
                .forEach(System.out::println);
    }

    private void loadPokemonFromCSV(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Saltar encabezado
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length >= 9) {
                    addPokemon(new Pokemon(data[1], data[2], data[3], data[8]));
                }
            }
            System.out.println("Datos de Pokémon cargados correctamente.");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo CSV: " + e.getMessage());
        }
    }
}