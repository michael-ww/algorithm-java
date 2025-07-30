package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

// 抢7游戏
public class HuaWeiB202537 {

    private static int count = 0;

    public static void main(String[] args) {
        String input = "10";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        
        Scanner scanner = new Scanner(System.in);
        int startNumber = scanner.nextInt();
        simulateGame(startNumber, true);
        System.err.println(count);
    }

    private static void simulateGame(int current, boolean isATurn) {
        if (current == 7) {
            if (!isATurn) {
                count++;
            }
            return;
        }
        if (current < 7) {
            return;
        }
        for (int move = 1; move <= 2; move++) {
            int next = current - move;
            if (next >= 7) {
                simulateGame(next, !isATurn);
            }
        }
    }
}
