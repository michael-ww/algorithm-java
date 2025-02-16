package gorgeous.algorithm.leetcode;

import java.util.Arrays;

public class LeetCode877 {

    public boolean stoneGame1(int[] piles) {
        if (piles == null) {
            throw new NullPointerException();
        }
        return this.stoneGame(piles, 0, piles.length - 1) > 0;
    }

    private int stoneGame(int[] piles, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return piles[leftIndex];
        }

        int leftScore = piles[leftIndex] - stoneGame(piles, leftIndex + 1, rightIndex);
        int rightScore = piles[rightIndex] - stoneGame(piles, leftIndex, rightIndex - 1);
        return Math.max(leftScore, rightScore);
    }

    public boolean stoneGame2(int[] piles) {
        if (piles == null) {
            throw new NullPointerException();
        }
        int[][] dp = new int[piles.length][piles.length];
        Arrays.fill(dp, Integer.MIN_VALUE);
        return this.stoneGame(piles, 0, piles.length - 1, dp) > 0;
    }

    private int stoneGame(int[] piles, int leftIndex, int rightIndex, int[][] dp) {
        if (leftIndex >= rightIndex) {
            return piles[leftIndex];
        }
        if (dp[leftIndex][rightIndex] != Integer.MIN_VALUE) {
            return dp[leftIndex][rightIndex];
        }
        int leftScore = piles[leftIndex] - this.stoneGame(piles, leftIndex + 1, rightIndex, dp);
        int rightScore = piles[rightIndex] - this.stoneGame(piles, leftIndex, rightIndex - 1, dp);
        int maxScore = Math.max(leftScore, rightScore);
        dp[leftIndex][rightIndex] = maxScore;
        return maxScore;
    }

    public boolean stoneGame3(int[] piles) {
        if (piles == null) {
            throw new NullPointerException();
        }
        int[][] dp = new int[piles.length][piles.length];
        for (int i = 0; i < piles.length; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = piles.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < piles.length; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][piles.length - 1] > 0;
    }

    public boolean stoneGame4(int[] piles) {
        if (piles == null) {
            throw new NullPointerException();
        }

        int[] dp = new int[piles.length];
        System.arraycopy(piles, 0, dp, 0, piles.length);
        for (int i = piles.length - 2; i >= 0; i--) {
            for (int j = i + 1; j < piles.length; j++) {
                dp[j] = Math.max(piles[i] - dp[j], piles[j] - dp[j - 1]);
            }
        }

        return dp[piles.length - 1] > 0;
    }

    public boolean stoneGame5(int[] piles) {
        if (piles == null) {
            throw new NullPointerException();
        }
        return true;
    }
}
