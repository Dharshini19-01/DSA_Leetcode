import java.util.ArrayList;
import java.util.List;

public class flowerPlant {
    public int[] gardenNoAdj(int n, int[][] paths) {

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] path : paths) {
            int a = path[0] - 1;
            int b = path[1] - 1;

            graph[a].add(b);
            graph[b].add(a);
        }
        int[] flower = new int[n];
        for (int i = 0; i < n; i++) {
            boolean[] used = new boolean[5];
            for (int neighbor : graph[i]) {
                used[flower[neighbor]] = true;
            }
            for (int f = 1; f <= 4; f++) {
                if (!used[f]) {
                    flower[i] = f;
                    break;
                }
            }
        }
        return flower;
    }
}
