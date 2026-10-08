class Solution {
    public int[] productExceptSelf(int[] nums) {
        int max = 1;
        int zeroes = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) { 
                zeroes++;
                continue;
            }
            max *= nums[i];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            if (zeroes > 0) {
                res[i] = 0;
                if (nums[i] == 0) { 
                    if (zeroes > 1) {
                        res[i] = 0;
                    } else {
                        res[i] = max;
                    }
                    continue;
                }
                continue;
            }
            res[i] = max / nums[i];
        }

        return res;
    }
}  
