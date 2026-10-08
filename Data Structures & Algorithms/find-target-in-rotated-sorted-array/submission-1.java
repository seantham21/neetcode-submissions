class Solution {
    public int search(int[] nums, int target) {
        
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (target > nums[mid]) {
                // mid in left larger subarray
                // [3, 4, 5, 6, 1, 2], target 6
                if (nums[mid] > nums[r]) { 
                    l = mid + 1;
                
                // mid in right smaller subarray
                // [5, 6, 1, 2, 3, 4], target 6
                } else {
                    if (target > nums[r]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
            } else {
                if (nums[mid] > nums[r]) {
                    if (target > nums[r]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }

                // [6, 1, 2, 3, 4, 5], target 6
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }
}
