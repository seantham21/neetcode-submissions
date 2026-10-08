class Solution {
    public int helper (int[] nums, int target, int min, int max) {
            int middle = (min + max) / 2;
            if (target == nums[middle]) {
                return middle;
            } else if (min >= max) {
                return -1;
            } else if (target < nums[middle]) {
                return helper(nums, target, min, middle - 1);
            } else if (target > nums[middle]) {
                return helper(nums, target, middle + 1, max);
            } else {
                return -1;
            }
        }

    public int search(int[] nums, int target) {
        int min = 0;
        int max = nums.length - 1;
        
        return helper(nums, target, 0, nums.length - 1);
    }
}
