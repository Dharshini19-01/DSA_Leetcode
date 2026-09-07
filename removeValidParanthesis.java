import java.util.Stack;

public class removeValidParanthesis {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        boolean[] remove = new boolean[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                stack.push(i);
            } 
            else if (ch == ')') {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    remove[i] = true;
                }
            }
        }
        while (!stack.isEmpty()) {
            remove[stack.pop()] = true;
        }
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!remove[i]) {
                answer.append(s.charAt(i));
            }
        }
        return answer.toString();
    }
}
