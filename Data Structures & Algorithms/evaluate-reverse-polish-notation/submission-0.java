class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                int right = numbers.pop();
                int left = numbers.pop();
                numbers.push(left + right);
            } else if (token.equals("-")) {
                int right = numbers.pop();
                int left = numbers.pop();
                numbers.push(left - right);
            } else if (token.equals("*")) {
                int right = numbers.pop();
                int left = numbers.pop();
                numbers.push(left * right);
            } else if (token.equals("/")) {
                int right = numbers.pop();
                int left = numbers.pop();
                numbers.push(left / right);
            } else {
                numbers.push(Integer.parseInt(token));
            }
        }
        return (!numbers.isEmpty()) ? numbers.pop() : 0;
    }
}
