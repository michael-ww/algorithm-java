package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

// 模拟消息队列
public class HuaWeiB20257 {

    public static void main(String[] args) {
        String sample = "2 22 1 11 4 44 5 55 3 33\n1 7 2 3";
        // String sample = "5 64 11 64 9 97\n9 11 4 9";
        System.setIn(new ByteArrayInputStream(sample.getBytes()));

        Scanner scanner = new Scanner(System.in);
        int[] input1 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] input2 = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[][] producers = new int[input1.length / 2][];
        for (int i = 0; i < input1.length / 2; i++) {
            producers[i] = new int[]{input1[i * 2], input1[i * 2 + 1]};
        }
        Arrays.sort(producers, (a, b) -> Integer.compare(a[0], b[0]));

        int[][] consumers = new int[input2.length / 2][];
        for (int i = 0; i < input2.length / 2; i++) {
            consumers[i] = new int[]{input2[i * 2], input2[i * 2 + 1]};
        }

        List<List<Integer>> messages = new ArrayList<>();
        for (int[] item : consumers) {
            messages.add(new ArrayList<>());
        }

        for (int[] producer : producers) {
            int producingTime = producer[0];
            int producingMsg = producer[1];
            for (int i = consumers.length - 1; i >= 0; i--) {
                int subscribeTime = consumers[i][0];
                int unsubscribeTime = consumers[i][1];
                if (producingTime >= subscribeTime && producingTime < unsubscribeTime) {
                    messages.get(i).add(producingMsg);
                    break;
                }
            }
        }

        for (List<Integer> message : messages) {
            if (message.isEmpty()) {
                System.out.println("-1");
            } else {
                System.out.println(message.stream().map(String::valueOf).collect(Collectors.joining(" ")));
            }
        }
    }
}
