import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class wordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        List<String> result = new ArrayList<>();
        backtrack(s, 0, set, new ArrayList<>(), result);
        return result;
    }
    private void backtrack(String s, int start, Set<String> set,List<String> path, List<String> result) {
        if (start == s.length()) {
            result.add(String.join(" ", path));
            return;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            String word = s.substring(start, end);
            if (set.contains(word)) {
                path.add(word);
                backtrack(s, end, set, path, result);
                path.remove(path.size() - 1);
            }
        }
    }
}
