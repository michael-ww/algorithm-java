package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Collectors;

// 流浪地球
public class HuaWeiE202549 {

    public static void main(String[] args) {
        // String input = "8 2\n0 2\n\n0 6";
        String input = "8 2\n0 0\n1 7";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        int total = scanner.nextInt();
        int batch = scanner.nextInt();
        int[] startTimes = new int[total];
        Arrays.fill(startTimes, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < batch; i++) {
            int time = scanner.nextInt();
            int position = scanner.nextInt();
            startTimes[position] = time;
            pq.add(new int[]{time, position});
        }

        while (!pq.isEmpty()) {
            int[] engine = pq.poll();
            int left = (engine[1] - 1 + total) % total;
            if (startTimes[left] == Integer.MAX_VALUE) {
                startTimes[left] = engine[0] + 1;
                pq.add(new int[]{startTimes[left], left});
            }
            int right = (engine[1] + 1) % total;
            if (startTimes[right] == Integer.MAX_VALUE) {
                startTimes[right] = engine[0] + 1;
                pq.add(new int[]{startTimes[right], right});
            }
        }

        int maxTime = Arrays.stream(startTimes).max().getAsInt();
        List<Integer> lastEngins = new ArrayList<>();
        for (int i = 0; i < startTimes.length; i++) {
            if (startTimes[i] == maxTime) {
                lastEngins.add(i);
            }
        }

        System.out.println(lastEngins.size());
        Collections.sort(lastEngins);
        System.out.println(lastEngins.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
