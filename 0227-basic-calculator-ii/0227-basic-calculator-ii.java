class Solution {
    public int calculate(String s) {
         int n = s.length();
        int num = 0;
        char sign = '+';

        java.util.Stack<Integer> stack = new java.util.Stack<>();

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);

            // build number
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            // if operator OR last character
            if (!Character.isDigit(c) && c != ' ' || i == n - 1) {

                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }

                sign = c;
                num = 0;
            }
        }

        // sum all values
        int result = 0;
        for (int val : stack) {
            result += val;
        }

        return result;
    }
}