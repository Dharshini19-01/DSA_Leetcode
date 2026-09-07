import java.util.Arrays;

public class taskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        Arrays.sort(freq);
        int maxFreq = freq[25];
        int idle = (maxFreq - 1) * n;
        for (int i = 24; i >= 0; i--) {
            idle -= Math.min(maxFreq - 1, freq[i]);
        }
        if (idle < 0) {
            idle = 0;
        }
        return tasks.length + idle;
    }
}
