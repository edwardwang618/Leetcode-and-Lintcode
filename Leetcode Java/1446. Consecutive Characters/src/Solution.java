public class Solution {
    public int maxPower(String s) {
        int res = 0;
        
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                j++;
            }
            
            res = Math.max(res, j - i);
            i = j - 1;
        }
        
        return res;
    }
}
