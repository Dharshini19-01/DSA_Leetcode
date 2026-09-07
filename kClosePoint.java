import java.util.PriorityQueue;

public class kClosePoint {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> max_heap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            int dist = x * x + y * y;
            max_heap.add(new int[]{dist, x, y});
            if (max_heap.size() > k) {
                max_heap.poll();
            }
        }
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] current = max_heap.poll();
            result[i][0] = current[1];
            result[i][1] = current[2];
        }
        return result;
    }
}
