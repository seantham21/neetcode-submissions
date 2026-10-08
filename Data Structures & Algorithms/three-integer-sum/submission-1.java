class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int curr = nums[i];
            int target = -curr;
            
            int left = i + 1;
            int right = nums.length - 1;        
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum < target) {
                    left++;
                    continue;
                } else if (sum > target) {
                    right--;
                    continue;
                }

                if (sum == target) {
                    List<Integer> triplet = new ArrayList<>();
                    triplet.add(curr);
                    triplet.add(nums[left]);
                    triplet.add(nums[right]);
                    res.add(triplet);
                    left++;
                    right--;
                }

                while ((left < right) && (nums[right] == nums[right + 1])) { right--; }
                while ((left < right) && (nums[left] == nums[left - 1])) { left++; }
            }
        }
        return res;
    }
}
