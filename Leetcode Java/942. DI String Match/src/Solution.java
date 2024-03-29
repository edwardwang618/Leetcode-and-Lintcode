public class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length(), l = 0, r = n;
        int[] res = new int[n + 1];
        for (int i = 0, idx = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'I') {
                res[idx++] = l++;
            } else {
                res[idx++] = r--;
            }
        }
        
        res[n] = l;
        return res;
    }
}
