
import java.util.Map;
import java.util.LinkedHashMap;

public class InputParser{
    
    public Map<String, String> parse(String raw) {
        Map<String, String> kv = new LinkedHashMap<>();
        for (String eachPart : raw.split(";")) {
            String[] eachResult = eachPart.split("=", 2);
            if (eachResult.length == 2) kv.put(eachResult[0].trim(), eachResult[1].trim());
        }
        return kv;
    }
}