package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

// 传递悄悄话
public class HuaWeiB20253 {

    public static void main(String[] args) {
        String sample = "0 9 20 -1 -1 15 7 -1 -1 -1 -1 3 2";
        System.setIn(new ByteArrayInputStream(sample.getBytes()));

        Scanner scanner = new Scanner(System.in);
        int[] array = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(dfs(array, 0));
    }

    private static int dfs(int[] array, int index) {
        if (index >= array.length || array[index] == -1) {
            return 0;
        }
        int leftTime = dfs(array, 2 * index + 1);
        int rightTime = dfs(array, 2 * index + 2);
        return array[index] + Math.max(leftTime, rightTime);
    }
}
