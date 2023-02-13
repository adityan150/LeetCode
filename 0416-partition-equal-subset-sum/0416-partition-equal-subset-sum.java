class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int e : nums) sum += e;
        
        if (sum % 2 != 0) return false;
        sum = sum / 2;
        
        boolean[][] dp = new boolean[nums.length+1][sum+1];
        // initialization
        for (int i = 0; i <= nums.length; i++)
            dp[i][0] = true;
        for (int i = 1; i <= sum; i++)
            dp[0][i] = false;
        
        // tabulation
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j >= nums[i-1])
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i-1]];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        
        return dp[nums.length][sum];
    }
    
//     boolean subsetSum(int[] nums, int t, int i, Boolean[][] dp) {
//         if (t == 0) return true;
//         if (i == nums.length || t < 0) return false;
        
//         if (dp[i][t] != null) return dp[i][t];
        
//         return dp[i][t] = subsetSum(nums, t - nums[i], i+1, dp)
//             || subsetSum(nums, t, i+1, dp);
//     }
}