package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.PriorityQueue;
import java.util.Scanner;

// 贪心歌手
public class HuaWeiB202531 {

    public static void main(String[] args) {
        String input = "10 2\n1 1 2\n120 20\n90 10";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int cities = scanner.nextInt();
        int cost = 0;
        for (int i = 0; i <= cities; i++) {
            cost += scanner.nextInt();
        }
        int[][] mds = new int[cities][2];
        for (int i = 0; i < cities; i++) {
            mds[i][0] = scanner.nextInt();
            mds[i][1] = scanner.nextInt();
        }
        int left = total - cost;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] md : mds) {
            int money = md[0];
            int decrease = md[1];
            while (money > 0) {
                if (pq.size() >= left) {
                    if (pq.peek() < money) {
                        pq.poll();
                        pq.add(money);
                    } else {
                        break;
                    }
                } else {
                    pq.add(money);
                }
                money -= decrease;
            }
        }

        System.out.println(pq.stream().reduce(Integer::sum).orElse(0));
    }
}
