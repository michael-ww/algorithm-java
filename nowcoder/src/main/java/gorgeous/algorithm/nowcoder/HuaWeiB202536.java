package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 无向图染色
public class HuaWeiB202536 {

    private static int count = 0;

    public static void main(String[] args) {
        // String input = "4 4\n1 2\n2 4\n3 4\n1 3";
        // String input = "3 3\n1 2\n1 3\n2 3";
        // String input = "4 3\n1 2\n2 3\n3 4";
        String input = "4 3\n1 2\n1 3\n2 3";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        int points = scanner.nextInt();
        int edges = scanner.nextInt();
        List<Integer>[] graph = new ArrayList[points];
        for (int i = 0; i < points; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges; i++) {
            int p1 = scanner.nextInt();
            int p2 = scanner.nextInt();
            graph[p1 - 1].add(p2 - 1);
            graph[p2 - 1].add(p1 - 1);
        }
        // 0: uncolored, 1: red, 2: black
        int[] color = new int[points];
        backtrack(graph, color, 0);
        System.out.println(count);
    }

    private static void backtrack(List<Integer>[] graph, int[] color, int index) {
        if (index == graph.length) {
            count++;
            return;
        }
        // Try coloring the node red if possible
        boolean canColorRed = true;
        for (int neighbor : graph[index]) {
            if (color[neighbor] == 1) {
                canColorRed = false;
                break;
            }
        }
        if (canColorRed) {
            color[index] = 1;
            backtrack(graph, color, index + 1);
            color[index] = 0;
        }
        // Always can color the node black
        color[index] = 2;
        backtrack(graph, color, index + 1);
        color[index] = 0;
    }
}
