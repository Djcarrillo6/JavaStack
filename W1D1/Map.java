import java.util.HashMap;
import java.util.Set;


public class Map {
    public static void main(String[] args) {
        HashMap<String, String> trackList = new HashMap<String, String>();
        trackList.put("Track1", "lorem lorem lore lorem");
        trackList.put("Track2", "ipsum lorem lore lorem");
        trackList.put("Track3", "lorem lorem ipsum lorem");
        trackList.put("Track4", "lorem lorem lore ipsum");

        Set<String> keys = trackList.keySet();
        for(String key : keys) {
            System.out.println(key);
            System.out.println(trackList.get(key));    
        }
    }
}