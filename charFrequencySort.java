import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class charFrequencySort {
    public String frequencySort(String s) {
    Map<Character, Integer> freqMap = new HashMap<>();
    for (char c : s.toCharArray()) {
        freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
    }

    PriorityQueue<Character> maxHeap = new PriorityQueue<>(
        (a, b) -> freqMap.get(b) - freqMap.get(a)
    );
    maxHeap.addAll(freqMap.keySet());

    StringBuilder sb = new StringBuilder();
    while (!maxHeap.isEmpty()) {
        char c = maxHeap.poll();
        for (int i = 0; i < freqMap.get(c); i++) {
            sb.append(c);
        }
    }
    return sb.toString();
}
}
