import java.util.PriorityQueue;

public class minCostPoints {
    public int minCostConnectPoints(int[][] points) {

        int n = points.length;
        boolean[] visited = new boolean[n];

        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) -> a[1] - b[1]);

        pq.offer(new int[]{0, 0});

        int totalCost = 0;
        int count = 0;

        while (count < n) {

            int[] current = pq.poll();

            int point = current[0];
            int cost = current[1];

            if (visited[point]) {
                continue;
            }

            visited[point] = true;
            totalCost += cost;
            count++;

            for (int next = 0; next < n; next++) {

                if (!visited[next]) {

                    int distance =
                        Math.abs(points[point][0] - points[next][0])
                        + Math.abs(points[point][1] - points[next][1]);

                    pq.offer(new int[]{next, distance});
                }
            }
        }

        return totalCost;
    }
}
