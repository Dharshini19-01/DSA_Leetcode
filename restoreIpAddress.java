import java.util.ArrayList;
import java.util.List;

public class restoreIpAddress {
    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        solve(s, 0, 0, "");
        return result;
    }

    void solve(String s, int index, int parts, String ip) {
        if (parts == 4) {
            if (index == s.length())
                result.add(ip.substring(0, ip.length() - 1));
            return;
        }

        for (int i = index; i < s.length() && i < index + 3; i++) {
            String part = s.substring(index, i + 1);

            if (part.length() > 1 && part.charAt(0) == '0')
                break;

            if (Integer.parseInt(part) > 255)
                break;

            solve(s, i + 1, parts + 1, ip + part + ".");
        }
    }
}
