public class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        
        int i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }
        
        if (i < 0) {
            return 0;
        }
        
        int j = i;
        while (j >= 0 && s.charAt(j) != ' ') {
            j--;
        }
        
        return i - j;
    }
    
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLastWord("hello wo "));
    }
}