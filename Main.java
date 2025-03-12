
import java.util.Comparator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main{
    public static void main(String[] args) throws ClassNotFoundException {
        //Variables y objetos que se usaran el en programa, incluyen el nombre del archivo, objetos, listas y el scanner
        final String filename = "pokemon_data_pokeapi.csv";
        ManejoDatos md = new ManejoDatos();
        ClassFactory cf = new ClassFactory();
        String[] opcionesMap = {"HashMap","TreeMap","LinkedHashMap"};
        Scanner sc = new Scanner(System.in);
        boolean x = true;

        //Opciones de funcionamiento. Seleccion del map a usar
        System.out.println("Ingrese la opción de map a usar: ");
        for(int i = 0; i<opcionesMap.length; i++){
            System.out.println(i + ")" +opcionesMap[i]);
        }
        int opcion = sc.nextInt();
        Map<String, Pokemon> pokedex = md.cargarPokemon(filename, opcionesMap[opcion], cf);

        TreeMap<String ,Pokemon> coleccionP = new TreeMap<>();

        while(x){
            System.out.println("---Colección Pokemon---\tSeleccione una opción");
            System.out.println("1)Agregar pokemon a la colección\n2)Mostrar datos de un pokemon\n3)Mostrar Nombre,Tipo 1 de pokemons en colección\n4)Mostrar Nombre,Tipo 1 de pokemons en pokedex\n5)Buscar por habilidad\n6)Salir");
            int opcionMenu = sc.nextInt();
            switch (opcionMenu) {
                case 1 -> {
                    sc.nextLine();
                    System.out.println("Ingrese el nombre del pokemon a agregar (Inicie con mayúsculas y si el nombre se compone de 2 palabras, separarlas  por - ):");
                    String name = sc.nextLine();
                    //Revisa si el pokemon está en el map, si está lo agrega al TreeMap de la colección personal
                    if(!pokedex.containsKey(name))
                        System.out.println("No se ha encontrado este pokemon");
                    else{
                        if(coleccionP.containsKey(name))
                            System.out.println("Ya tienes a este pokemon en tu colección");
                        else{
                            coleccionP.put(name, pokedex.get(name));
                            System.out.println("Nuevo pokemon agregado");
                        }
                    }
                }
                case 2 -> {
                    sc.nextLine();
                    System.out.println("Ingrese el nombre del pokemon a agregar (Inicie con mayúsculas y si el nombre se compone de 2 palabras, separarlas  por - ):");
                    String name = sc.nextLine();
                    if(!pokedex.containsKey(name))
                        System.out.println("No se ha encontrado este pokemon");
                    else
                        System.out.println(pokedex.get(name).toString());
                }
                case 3 -> {
                    System.out.println("----Pokemons en colección----");
                    if (!coleccionP.isEmpty()) {
                        // Ordenar e imprimir Pokémon directamente desde la colección
                        coleccionP.values().stream()
                            .sorted(Comparator.comparing(Pokemon::getType1))
                            .forEach(pokemon -> System.out.println("Tipo 1: " + pokemon.getType1() + ", Nombre: " + pokemon.getName()));
                    } else {
                        System.out.println("No tienes pokemons en tu colección");
                    } 
                }
                case 4 -> {
                    if (!pokedex.isEmpty()) {
                        // Ordenar e imprimir Pokémon directamente desde la colección
                        pokedex.values().stream()
                            .sorted(Comparator.comparing(Pokemon::getType1))
                            .forEach(pokemon -> System.out.println("Tipo 1: " + pokemon.getType1() + ", Nombre: " + pokemon.getName()));
                    } else {
                        System.out.println("No tienes pokemons en tu colección");
                    } 
                }
                case 5 -> {
                    System.out.println("----Buscador por habilidad----");
                    System.out.println("Ingrese el nombre de la habilidad a buscar (Inicie con mayúsculas y si el nombre se compone de 2 palabras, separarlas  por - ):");
                    sc.nextLine();
                    String ability = sc.nextLine();
                    //
                    for (Map.Entry<String, Pokemon> entry : pokedex.entrySet()) {
                        if(entry.getValue().getAbilities().contains(ability))
                            System.out.println(entry.getValue().toString());
                    }
                }
                case 6 -> {
                    x = false;
                    sc.close();
                    System.out.println("Saliendo...");
                }
                default -> System.out.println("Ingrese una opción correcta");
            }

        }
    }
}