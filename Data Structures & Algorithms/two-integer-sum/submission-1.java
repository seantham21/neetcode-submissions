class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> nums_index = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if (nums_index.containsKey(diff)) {
                int[] result = {nums_index.get(diff), i};
                return result;
            }

            nums_index.put(nums[i], i);
        }
        return new int[] {0,0};
    }
}
