package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

// 5G网络建设
public class HuaWeiC202545 {

    public static void main(String[] args) {
        // String input = "3\n3\n1 2 3 0\n1 3 1 0\n2 3 5 0";
        String input = "3\n3\n1 2 3 0\n1 3 1 0\n2 3 5 1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int pairCount = scanner.nextInt();

        // Edge[] edges = new Edge[pairCount];
        // for (int i = 0; i < pairCount; i++) {
        //     int x = scanner.nextInt();
        //     int y = scanner.nextInt();
        //     int z = scanner.nextInt();
        //     int p = scanner.nextInt();
        //     edges[i] = new Edge(x - 1, y - 1, p == 0 ? z : 0);
        // }

        // Arrays.sort(edges, (a, b) -> a.getWeight() - b.getWeight());
        // UnionFindSet ufs = new UnionFindSet(count);
        // int minimalWeight = 0, edgeCount = 0;
        // for (Edge edge : edges) {
        //     if (ufs.find(edge.getFrom()) != ufs.find(edge.getTo())) {
        //         ufs.union(edge.getFrom(), edge.getTo());
        //         minimalWeight += edge.getWeight();
        //         edgeCount++;
        //     }
        // }

        // System.out.println(edgeCount == count - 1 ? minimalWeight : -1);
    }
}
