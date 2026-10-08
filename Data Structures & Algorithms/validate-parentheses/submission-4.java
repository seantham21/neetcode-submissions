class Solution {
    public boolean isValid(String s) {
        // Edge case: odd length can never be fully paired
        if (s.length() % 2 != 0) {
            return false;
        }

        int open_idx = 0;
        char[] stack = new char[s.length() / 2];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Push opening brackets
            if (c == '(' || c == '{' || c == '[') {
                // extra safety: avoid overflow if input is weird
                if (open_idx == stack.length) return false;
                stack[open_idx] = c;
                open_idx++;
                continue;
            }

            // If we see a closing bracket but stack is empty → invalid
            if (open_idx == 0) {
                return false;
            }

            // Top of stack is at open_idx - 1
            char top = stack[open_idx - 1];

            // Check for matching pair
            if ((c == ')' && top == '(') ||
                (c == '}' && top == '{') ||
                (c == ']' && top == '[')) {
                // "Pop" by moving open_idx down
                open_idx--;
                continue;
            } else {
                return false;
            }
        }

        // Valid only if no unmatched opening brackets left
        return open_idx == 0;
    }
}
