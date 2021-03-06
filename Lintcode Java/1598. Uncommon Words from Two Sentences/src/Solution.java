import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    /**
     * @param A: Sentence A
     * @param B: Sentence B
     * @return: Uncommon Words from Two Sentences
     */
    public String[] uncommonFromSentences(String A, String B) {
        // Write your code here.
        Map<String, Integer> map = new HashMap<>();
        for (String s : A.split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        for (String s : B.split(" ")) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
    
        List<String> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            }
        }
        
        String[] res = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        
        return res;
    }
}
