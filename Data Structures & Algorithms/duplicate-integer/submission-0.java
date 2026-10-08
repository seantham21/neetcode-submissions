class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashMap<Integer, Integer> inArray = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (inArray.containsKey(nums[i])) {
                return true;
            } else {
                inArray.put(nums[i], 1);
            }
        }
        return false;
    }
}