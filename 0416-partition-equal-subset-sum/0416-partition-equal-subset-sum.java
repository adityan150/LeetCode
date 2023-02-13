class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int e : nums) sum += e;
        
        if (sum % 2 != 0) return false;
        sum = sum / 2;
        
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        
        // tabulation
        for (int i = 1; i <= nums.length; i++) {
            for (int j = sum; j >= 1; j--) {
                if (j >= nums[i-1])
                    dp[j] = dp[j] || dp[j - nums[i-1]];
            }
        }
        
        return dp[sum];
    }
    
//     boolean subsetSum(int[] nums, int t, int i, Boolean[][] dp) {
//         if (t == 0) return true;
//         if (i == nums.length || t < 0) return false;
        
//         if (dp[i][t] != null) return dp[i][t];
        
//         return dp[i][t] = subsetSum(nums, t - nums[i], i+1, dp)
//             || subsetSum(nums, t, i+1, dp);
//     }
}