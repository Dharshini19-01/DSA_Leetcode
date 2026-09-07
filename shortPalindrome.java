public class shortPalindrome{
    public String shortestPalindrome(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev;
        int n = combined.length();
        int[] fail = new int[n];
        fail[0] = 0;
        for (int i = 1; i < n; i++) {
            int j = fail[i - 1];
            while (j > 0 && combined.charAt(i) != combined.charAt(j)) {
                j = fail[j - 1];
            }
            if (combined.charAt(i) == combined.charAt(j)) {
                j++;
            }
            fail[i] = j;
        }
        int palinLen = fail[n - 1];
        String toAdd = rev.substring(0, s.length() - palinLen);
        return toAdd + s;
    }
}