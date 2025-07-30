package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

// 简易内存池
public class HuaWeiB202534 {

    private static final int MAX_SIZE = 100;
    private static final Map<Integer, Integer> memoryMap = new TreeMap<>();

    public static void main(String[] args) {
        // String input = "2\nREQUEST=10\nREQUEST=20";
        String input = "5\nREQUEST=10\nREQUEST=20\nRELEASE=0\nREQUEST=20\nREQUEST=10";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        String[][] commands = new String[length][2];
        for (int i = 0; i < length; i++) {
            commands[i] = scanner.next().split("=");
        }
        for (String[] cmd : commands) {
            if (cmd[0].equals("REQUEST")) {
                request(Integer.parseInt(cmd[1]));
            } else if (cmd[0].equals("RELEASE")) {
                release(Integer.parseInt(cmd[1]));
            }
        }
    }

    private static void request(int size) {
        if (size <= 0 || size > MAX_SIZE) {
            System.out.println("error");
        } else {
            int start = 0;
            if (!memoryMap.isEmpty()) {
                for (Map.Entry<Integer, Integer> entry : memoryMap.entrySet()) {
                    if (entry.getKey() - start >= size) {
                        break;
                    } else {
                        start = entry.getValue() + 1;
                    }
                }
            }
            if (MAX_SIZE - start >= size) {
                memoryMap.put(start, start + size - 1);
                System.out.println(start);
            } else {
                System.out.println("error");
            }
        }
    }

    private static void release(int start) {
        if (memoryMap.containsKey(start)) {
            memoryMap.remove(start);
        } else {
            System.out.println("error");
        }
    }
}
