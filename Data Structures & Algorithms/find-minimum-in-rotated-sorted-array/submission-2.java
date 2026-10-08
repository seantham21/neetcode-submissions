class Solution {
    public int findMin(int[] nums) {
        // Base case: If no rotation / rotate by a multiple of length
        if (nums[0] < nums[nums.length - 1]) { return nums[0]; }

        int l = 0;
        int r = nums.length - 1;
        int mid = 0;

        while (l < r) {
            mid = l + ((r - l) / 2);
            if (l == r - 1) { return nums[mid + 1]; }
            
            if (nums[l] < nums[mid]) {
                l = mid;
            
            // if r > mid,  min in left, recurse on the left
            } else if (nums[r] > nums[mid]) {
                r = mid;
            }
        }
        return nums[0];
    }
}
