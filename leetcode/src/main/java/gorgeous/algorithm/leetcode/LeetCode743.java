package gorgeous.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LeetCode743 {

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : times) {
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
        }
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;
        boolean[] visited = new boolean[n + 1];
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        heap.add(new int[]{k, 0});
        while (!heap.isEmpty()) {
            int[] node = heap.poll();
            if (visited[node[0]]) {
                continue;
            }
            visited[node[0]] = true;
            for (int[] edge : graph.get(node[0])) {
                if (!visited[edge[0]] && distance[node[0]] + edge[1] < distance[edge[0]]) {
                    distance[edge[0]] = distance[node[0]] + edge[1];
                    visited[edge[0]] = true;
                    heap.add(new int[]{edge[0], distance[edge[0]]});
                }
            }
        }

        int answer = Integer.MIN_VALUE;
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                return -1;
            }
            answer = Math.max(distance[i], answer);
        }

        return answer;
    }
}
