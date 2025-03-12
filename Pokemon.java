
import java.util.List;

public class Pokemon {
    private int num_Pokedex;
    private String name;
    private String type1;
    private String type2 = "none";
    private String classifiaction;
    private double height;
    private double weight;
    List<String> abilities;
    private int generation;
    private boolean legendary;

    public Pokemon() {
    }

    public Pokemon(int num_Pokedex, String name, String type1, String type2, String classifiaction, double height, double weight, List<String> abilities, int generation, boolean legendary) {
        this.num_Pokedex = num_Pokedex;
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.classifiaction = classifiaction;
        this.height = height;
        this.weight = weight;
        this.abilities = abilities;
        this.generation = generation;
        this.legendary = legendary;
    }
    
    public void setNum_Pokedex(int num_Pokedex) {
        this.num_Pokedex = num_Pokedex;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setType1(String type1) {
        this.type1 = type1;
    }
    public void setType2(String type2) {
        this.type2 = type2;
    }
    public void setClassifiaction(String classifiaction) {
        this.classifiaction = classifiaction;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }
    public void setAbilities(List<String> abilities) {
        this.abilities = abilities;
    }
    public void setGeneration(int generation) {
        this.generation = generation;
    }
    public void setLegendary(boolean legendary) {
        this.legendary = legendary;
    }


    public int getNum_Pokedex() {
        return num_Pokedex;
    }
    public String getName() {
        return name;
    }
    public String getType1() {
        return type1;
    }
    public String getType2() {
        return type2;
    }
    public String getClassifiaction() {
        return classifiaction;
    }
    public double getHeight() {
        return height;
    }
    public double getWeight() {
        return weight;
    }
    public List<String> getAbilities() {
        return abilities;
    }
    public int getGeneration() {
        return generation;
    }
    public boolean getLegendary(){
        return legendary;
    }
    @Override
    public String toString(){
        String value = "----------------------------------------------------------\nNo. Pokedex: " + this.num_Pokedex + "\nNombre: " + this.name + "\nTipo: " + this.getType1() + "\nTipo 2: " + this.type2 + 
            "\nClasificiación: " + this.classifiaction +"\nAltura: " + this.height + "\nPeso: " + this.weight + "\nHabilidades: " + 
            String.join(",", this.abilities) + "\nGeneración: " + this.getGeneration() + "\nLegendario: " + (this.legendary ? "Si": "No") + "\n----------------------------------------------------------";
        return value;
    }
}
