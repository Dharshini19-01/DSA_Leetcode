import java.util.Arrays;

public class findHindex {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            int papersWithAtLeastH = n - i; 
            int h = citations[i];
            
            if (papersWithAtLeastH <= h) {
                return papersWithAtLeastH;
            }
        }
        return 0;
    }
}
