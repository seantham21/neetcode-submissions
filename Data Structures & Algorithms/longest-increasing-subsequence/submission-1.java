class Solution {
    private HashMap<Integer, Integer> lengthI = new HashMap<>();
    
    public int lengthOfLIS(int[] nums) {
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, lis(nums, i));
        }

        return res;
    }

    public int lis(int[] nums, int i) {
        if (lengthI.containsKey(i)) {
            return lengthI.get(i);
        }

        int res = 1;
        for (int j = 0; j < i; j++) {
            if (nums[i] > nums[j]) {
                res = Math.max(res, 1 + lis(nums, j));
            }
        }
        lengthI.put(i, res);

        return res;
    }
}
