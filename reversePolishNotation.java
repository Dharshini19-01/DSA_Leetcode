import java.util.Stack;

public class reversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (!token.equals("+") &&
                !token.equals("-") &&
                !token.equals("*") &&
                !token.equals("/")) {
                stack.push(Integer.parseInt(token));
                continue;
            }
            int b = stack.pop();
            int a = stack.pop();
            int result;
            if (token.equals("+")) {
                result = a + b;
            }
            else if (token.equals("-")) {
                result = a - b;
            }
            else if (token.equals("*")) {
                result = a * b;
            }
            else {
                result = a / b;
            }
            stack.push(result);
        }
        return stack.peek();
    }
}
