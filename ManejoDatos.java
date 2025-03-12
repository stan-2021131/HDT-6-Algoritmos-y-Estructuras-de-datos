
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ManejoDatos{
    public Map<String, Pokemon> cargarPokemon(String fileName, String mapName, ClassFactory cf) throws ClassNotFoundException{
        Map<String, Pokemon> mp = cf.createMap(mapName);
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))){
            String line;
            br.readLine();
            while((line = br.readLine()) != null){
                String[] data = line.split(",");
                Pokemon pk = strToPokemon(data);
                mp.put(pk.getName(), pk);
            }
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo: " + e.getMessage());
        }
        return mp;
    }

    public Pokemon strToPokemon(String[] data){
        Pokemon newPk = new Pokemon();
        newPk.setName(data[0]);
        newPk.setNum_Pokedex(Integer.parseInt(data[1]));
        newPk.setType1(data[2]);
        if(!data[3].equals("")) newPk.setType2(data[3]);
        newPk.setClassifiaction(data[4]);
        newPk.setHeight(Double.parseDouble(data[5]));
        newPk.setWeight(Double.parseDouble(data[6]));
        newPk.setLegendary(data[data.length - 1].equals("yes"));
        newPk.setGeneration(Integer.parseInt(data[data.length - 2]));
        List<String> abilities = new ArrayList<>();
        for(int i = 7; i<(data.length-2); i++){
            String clearData = data[i].replace("\"", "");
            abilities.add(clearData);
        }
        newPk.setAbilities(abilities);
        return newPk;
    }
}