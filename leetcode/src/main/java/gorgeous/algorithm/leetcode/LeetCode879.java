package gorgeous.algorithm.leetcode;

public class LeetCode879 {

    public int profitableSchemes1(int n, int minProfit, int[] group, int[] profit) {
        return this.recurring(group, profit, 0, n, minProfit);
    }

    private int recurring(int[] group, int[] profit, int project, int people, int target) {
        if (people <= 0) {
            return target <= 0 ? 1 : 0;
        }
        if (project >= group.length) {
            return target <= 0 ? 1 : 0;
        }

        int skipped = this.recurring(group, profit, project + 1, people, target);
        int chosen = 0;
        if (group[project] <= people) {
            chosen = this.recurring(group, profit, project + 1, people - group[project], target - profit[project]);
        }

        return (skipped + chosen) % 1000000007;
    }

    public int profitableSchemes2(int n, int minProfit, int[] group, int[] profit) {
        int[][][] dp = new int[group.length][n + 1][minProfit + 1];
        for (int i = 0; i < group.length; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return this.recurring(group, profit, 0, n, minProfit, dp);
    }

    private int recurring(int[] group, int[] profit, int project, int people, int target, int[][][] dp) {
        if (people <= 0) {
            return target <= 0 ? 1 : 0;
        }
        if (project >= group.length) {
            return target <= 0 ? 1 : 0;
        }

        if (dp[project][people][target] != -1) {
            return dp[project][people][target];
        }
        int skipped = this.recurring(group, profit, project + 1, people, target, dp);
        int chosen = 0;
        if (group[project] <= people) {
            chosen = this.recurring(group, profit, project + 1, people - group[project],
                    Math.max(0, target - profit[project]));
        }
        dp[project][people][target] = (skipped + chosen) % 1000000007;
        return (skipped + chosen) % 1000000007;
    }

    public int profitableSchemes3(int n, int minProfit, int[] group, int[] profit) {
        int[][][] dp = new int[group.length + 1][n + 1][minProfit + 1];
        for (int i = group.length; i >= 0; i--) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    if (i == group.length) {
                        dp[i][j][k] = k == 0 ? 1 : 0;
                        continue;
                    }
                    if (j == 0) {
                        dp[i][j][k] = k == 0 ? 1 : 0;
                        continue;
                    }
                    int skipped = dp[i + 1][j][k];
                    int chosen = 0;
                    if (group[i] <= j) {
                        chosen = dp[i + 1][j - group[i]][Math.max(0, k - profit[i])];
                    }
                    dp[i][j][k] = (skipped + chosen) % 1000000007;
                }
            }
        }

        return dp[0][n][minProfit];
    }

    public int profitableSchemes4(int n, int minProfit, int[] group, int[] profit) {
        int[][] dp = new int[n + 1][minProfit + 1];
        for (int i = group.length; i >= 0; i--) {
            for (int j = n; j >= 0; j--) {
                for (int k = minProfit; k >= 0; k--) {
                    if (i == group.length) {
                        dp[j][k] = k == 0 ? 1 : 0;
                        continue;
                    }
                    if (j == 0) {
                        dp[j][k] = k == 0 ? 1 : 0;
                        continue;
                    }
                    dp[j][k] += group[i] <= j ? dp[j - group[i]][Math.max(0, k - profit[i])] % 1000000007 : 0;
                }
            }
        }

        return dp[n][minProfit];
    }
}
