public class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int i = -1;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[++i] = nums[j];
            }
        }
        
        return i + 1;
    }
}
