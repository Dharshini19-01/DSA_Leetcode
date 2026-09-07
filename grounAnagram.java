import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class grounAnagram {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>>map =  new HashMap<>();
        for(String s : strs){
            char[]arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            map.putIfAbsent(key,new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
