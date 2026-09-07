import java.util.ArrayList;
import java.util.List;

public class letterCombine {
    String[] map = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return result;
        solve(digits, 0, "");
        return result;
    }

    void solve(String digits, int index, String current) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }
        String letters = map[digits.charAt(index) - '0'];

        for (char ch : letters.toCharArray()) {
            solve(digits, index + 1, current + ch);
        }
    }
}

