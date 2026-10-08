class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) { return 0; }
        HashSet<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longest = 1;
        for (int i = 0; i < nums.length; i++) {
            if (numSet.contains(nums[i] - 1)) {
                continue;
            }

            int curr = nums[i];
            int counter = 1;
            while (numSet.contains(curr + 1)) {
                counter++;
                curr++;
            }
            longest = Math.max(longest, counter);
        }   
        return longest;
    }
}
