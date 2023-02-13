class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int e : nums) sum += e;
        
        if (sum % 2 != 0) return false;
        sum = sum / 2;
        
        Boolean[][] dp = new Boolean[nums.length][sum+1];
        
        return subsetSum(nums, sum, 0, dp);
    }
    
    boolean subsetSum(int[] nums, int t, int i, Boolean[][] dp) {
        if (t == 0) return true;
        if (i == nums.length || t < 0) return false;
        
        if (dp[i][t] != null) return dp[i][t];
        
        return dp[i][t] = subsetSum(nums, t - nums[i], i+1, dp)
            || subsetSum(nums, t, i+1, dp);
    }
}