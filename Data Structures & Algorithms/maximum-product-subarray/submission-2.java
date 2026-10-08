class Solution {
    public int maxProduct(int[] nums) {
        int currMax = nums[0];
        int currMin = nums[0];
        int res = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i] * currMax;
            currMax = Math.max(nums[i], 
                Math.max((nums[i] * currMin), (nums[i] * currMax)));
            currMin = Math.min(nums[i], 
                Math.min((nums[i] * currMin), temp));
            
            res = Math.max(res,currMax);
        }

        return res;
    }
}
