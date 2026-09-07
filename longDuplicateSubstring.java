import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class longDuplicateSubstring {
    String longestDupSubstring(String s) {
        int n = s.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = s.charAt(i) - 'a';
        }

        int base = 26;
        long mod = 1_000_000_007L;

        int low = 1, high = n - 1;
        String answer = "";

        while (low <= high) {
            int mid = low + (high - low) / 2;
            String result = check(mid, nums, s, base, mod);
            if (result != null) {
                answer = result;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return answer;
    }

    private String check(int length, int[] nums, String s, int base, long mod) {
        int n = nums.length;
        if (length == 0) return null;

        long power = 1;
        for (int i = 0; i < length - 1; i++) {
            power = (power * base) % mod;
        }

        long h = 0;
        for (int i = 0; i < length; i++) {
            h = (h * base + nums[i]) % mod;
        }

        Map<Long, List<Integer>> seen = new HashMap<>();
        seen.computeIfAbsent(h, k -> new ArrayList<>()).add(0);

        for (int i = length; i < n; i++) {
            h = (((h - nums[i - length] * power % mod + mod) % mod) * base + nums[i]) % mod;

            int start = i - length + 1;

            if (seen.containsKey(h)) {
                String candidate = s.substring(start, start + length);
                for (int prevStart : seen.get(h)) {
                    if (s.substring(prevStart, prevStart + length).equals(candidate)) {
                        return candidate;
                    }
                }
            }
            seen.computeIfAbsent(h, k -> new ArrayList<>()).add(start);
        }

        return null;
    }
}
}
