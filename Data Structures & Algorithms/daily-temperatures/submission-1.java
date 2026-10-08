class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        Arrays.fill(res, 0);

        for (int i = 0; i < temperatures.length; i++) {
            while ((!stack.isEmpty()) && (temperatures[i] > stack.peek()[0])) {
                int[] curr = stack.pop();
                res[curr[1]] = i - curr[1];
            }

            stack.push(new int[]{temperatures[i], i});
        }

        return res;
    }
}
