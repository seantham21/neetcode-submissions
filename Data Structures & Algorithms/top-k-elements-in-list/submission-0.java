class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // create hashmap to store number, count pairs
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // initialise array of buckets
        ArrayList<Integer>[] buckets = new ArrayList[nums.length + 1];
        for (int i = 0; i < nums.length + 1; i++) {
            buckets[i] = new ArrayList<>();
        }

        // insert keys into frequency buckets
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            int number = entry.getKey();
            int counter = entry.getValue();
            buckets[counter].add(number);
        }

        // extract top k
        int[] res = new int[k];
        int curr = 0;
        for (int i = nums.length; i > 0; i--) { // note that nums.length + 1 gives index error
            for (int num : buckets[i]) {
                res[curr] = num;
                curr++;
                if (curr == k) { return res; }
            } 
        }
        return res;
    }
}
