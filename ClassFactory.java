
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class ClassFactory {
    public Map<String, Pokemon> createMap(String name)throws ClassNotFoundException{
        switch (name) {
            case "HashMap" -> {return new HashMap<>();}
            case "TreeMap" -> {return new TreeMap<>();}
            case "LinkedHashMap" -> {return new LinkedHashMap<>();}
            default -> throw new AssertionError();
        }
    }
}
