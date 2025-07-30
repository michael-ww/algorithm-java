package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Scanner;

// 分披萨
public class HuaWeiC202551 {

    public static void main(String[] args) {
        String sample = "5\n8\n2\n10\n5\n7";
        System.setIn(new ByteArrayInputStream(sample.getBytes()));

        Scanner scanner = new Scanner(System.in);
        int pizzaCount = scanner.nextInt();
        int[] pizza = new int[pizzaCount];
        for (int i = 0; i < pizzaCount; i++) {
            pizza[i] = scanner.nextInt();
        }

        int[][] dp = new int[pizzaCount][pizzaCount];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        long answer = 0;
        for (int i = 0; i < pizzaCount; i++) {
            answer = Math.max(answer, getMax(pizza, dp, (i + 1) % pizzaCount, (i + pizzaCount - 1) % pizzaCount) + pizza[i]);
        }
        System.out.println(answer);

    }

    private static int getMax(int[] pizza, int[][] dp, int left, int right) {
        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        if (pizza[left] > pizza[right]) {
            left = (left + 1) % pizza.length;
        } else {
            right = (right + pizza.length - 1) % pizza.length;
        }

        if (left == right) {
            dp[left][right] = pizza[left];
        } else {
            dp[left][right] = Math.max(pizza[left] + getMax(pizza, dp, (left + 1) % pizza.length, right), pizza[right] + getMax(pizza, dp, left, (right + pizza.length - 1) % pizza.length));
        }
        return dp[left][right];
    }
}
