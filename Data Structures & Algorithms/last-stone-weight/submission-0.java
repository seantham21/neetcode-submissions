class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < stones.length; i++) {
            minHeap.add(-stones[i]);
        }

        while (minHeap.size() > 1) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            if (first < second) {
                int diff = first - second;
                minHeap.add(diff);
            }
        }

        if (minHeap.size() == 0) {return 0;}
        return -minHeap.poll();
    }
}
