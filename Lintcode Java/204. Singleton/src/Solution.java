class Solution {
    
    private static final Solution instance = new Solution();
    
    private Solution() {
    }
    
    /**
     * @return: The same instance of this class every time
     */
    public static Solution getInstance() {
        // write your code here
        return instance;
    }
}