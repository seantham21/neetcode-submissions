class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '}') {
                if (!stack.isEmpty() && stack.pop() == '{') {
                    continue;
                } else {
                    return false;
                }
            }
            if (c == ']') {
                if (!stack.isEmpty() && stack.pop() == '[') {
                    continue;
                } else {
                    return false;
                }
            }
            if (c == ')') {
                if (!stack.isEmpty() && stack.pop() == '(') {
                    continue;
                } else {
                    return false;
                }
            }

            stack.push(c);
        }
        return stack.isEmpty();
    }
}
