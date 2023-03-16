class Solution {
    public int jump(int[] nums) {
        int N = nums.length;
        
        // create a window, each window shift is equal to one jump
        int left = 0;
        int right = 0;
        int jumps = 0;
        
        while (right < N-1) {
            int farthest = 0;
            
            for (int i = left; i <= right; i++)
                farthest = Math.max(farthest, i + nums[i]);
            
            // shift window and increment jump
            left = right + 1;
            right = farthest;
            jumps++;
        }
        return jumps;
    }
}