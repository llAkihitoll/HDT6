public public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el tipo de almacenamiento: 1) HashMap, 2) TreeMap, 3) LinkedHashMap");
        int option = scanner.nextInt();
        scanner.nextLine();

        PokemonService service = new PokemonService(PokemonFactory.getMapStrategy(option));

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar un Pokémon a la colección del usuario");
            System.out.println("2. Mostrar datos de un Pokémon");
            System.out.println("3. Mostrar la colección del usuario ordenada por Type1");
            System.out.println("4. Mostrar todos los Pokémon ordenados por Type1");
            System.out.println("5. Mostrar Pokémon por habilidad");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Ingrese el nombre del Pokémon a agregar: ");
                    String pokemonName = scanner.nextLine();
                    service.addPokemonToUserCollection(pokemonName);
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del Pokémon a buscar: ");
                    String name = scanner.nextLine();
                    Pokemon found = service.getPokemon(name);
                    System.out.println(found != null ? found : "Pokémon no encontrado");
                    break;
                case 3:
                    System.out.println("Colección del usuario ordenada por Type1:");
                    service.listUserCollectionSortedByType1();
                    break;
                case 4:
                    System.out.println("Todos los Pokémon ordenados por Type1:");
                    service.listAllSortedByType1();
                    break;
                case 5:
                    System.out.print("Ingrese la habilidad: ");
                    String ability = scanner.nextLine();
                    service.listByAbility(ability);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }
}