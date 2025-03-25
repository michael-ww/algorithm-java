package gorgeous.algorithm.leetcode;

import java.util.Arrays;

public class LeetCode403 {

    public boolean canCross1(int[] stones) {
        Boolean[][] dp = new Boolean[stones.length][];
        return this.dfs(stones, 0, 0, dp);
    }

    private boolean dfs(int[] stones, int index, int step, Boolean[][] dp) {
        if (index >= stones.length - 1) {
            return true;
        }
        if (dp[index][step] != null) {
            return dp[index][step];
        }
        for (int distance = step - 1; distance <= step + 1; distance++) {
            if (distance > 0) {
                int targetIndex = Arrays.binarySearch(stones, index + 1, stones.length - 1, stones[index] + distance);
                if (targetIndex >= 0 && this.dfs(stones, targetIndex, distance, dp)) {
                    return dp[index][step] = true;
                }
            }
        }
        return dp[index][step] = false;
    }

    public boolean canCross2(int[] stones) {
        Boolean[][] dp = new Boolean[stones.length][];
        dp[0][0] = true;
        for (int i = 1; i < stones.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int k = stones[i] - stones[j];
                if (k > j + 1) {
                    break;
                }
                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                if (i == stones.length - 1 && dp[i][k]) {
                    return true;
                }
            }
        }
        return false;
    }
}
