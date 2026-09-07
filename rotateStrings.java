public class rotateStrings {
    public boolean rotateString(String s, String goal) {
    if (s.length() != goal.length()) {
            return false;
        }
        String str = s + s;
        return str.contains(goal);
    }
}
