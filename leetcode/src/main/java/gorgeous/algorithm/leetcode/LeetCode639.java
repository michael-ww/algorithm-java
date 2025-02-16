package gorgeous.algorithm.leetcode;

import java.util.Arrays;

public class LeetCode639 {

    public int numDecodings1(String s) {
        if (s == null || s.isEmpty() || s.isBlank()) {
            return 0;
        }
        return this.numDecodings(s, 0);
    }

    private int numDecodings(String s, int index) {
        if (index >= s.length()) {
            return 1;
        }
        if (s.charAt(index) == '0') {
            return 0;
        }
        int answer = this.numDecodings(s, index + 1) * (s.charAt(index) == '*' ? 9 : 1);
        if (index + 1 < s.length()) {
            if (s.charAt(index) == '*' && s.charAt(index + 1) == '*') {
                answer += this.numDecodings(s, index + 2) * 15;
            } else if (s.charAt(index) == '*' && s.charAt(index + 1) != '*') {
                answer += this.numDecodings(s, index + 2) * ((s.charAt(index + 1) - '0') > 6 ? 1 : 2);
            } else if (s.charAt(index) != '*' && s.charAt(index + 1) == '*') {
                if (s.charAt(index) == '1') {
                    answer += this.numDecodings(s, index + 2) * 9;
                } else if (s.charAt(index) == '2') {
                    answer += this.numDecodings(s, index + 2) * 6;
                }
            } else if (s.charAt(index) != '*' && s.charAt(index + 1) != '*') {
                if ((s.charAt(index) - '0') * 10 + (s.charAt(index + 1) - '0') <= 26) {
                    answer += this.numDecodings(s, index + 2);
                }
            }
        }
        return answer % 1000000007;
    }

    public int numDecodings2(String s) {
        if (s == null || s.isEmpty() || s.isBlank()) {
            return 0;
        }
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return this.numDecodings(s, 0, dp);
    }

    private int numDecodings(String s, int index, int[] dp) {
        if (index >= s.length()) {
            return 1;
        }
        if (s.charAt(index) == '0') {
            return 0;
        }
        if (dp[index] != -1) {
            return dp[index];
        }

        long answer = this.numDecodings(s, index + 1, dp) * (s.charAt(index) == '*' ? 9 : 1);
        if (index + 1 < s.length()) {
            if (s.charAt(index) == '*' && s.charAt(index + 1) == '*') {
                answer += this.numDecodings(s, index + 2, dp) * 15;
            } else if (s.charAt(index) == '*' && s.charAt(index + 1) != '*') {
                answer += this.numDecodings(s, index + 2, dp) * ((s.charAt(index + 1) - '0') > 6 ? 1 : 2);
            } else if (s.charAt(index) != '*' && s.charAt(index + 1) == '*') {
                if (s.charAt(index) == '1') {
                    answer += this.numDecodings(s, index + 2, dp) * 9;
                } else if (s.charAt(index) == '2') {
                    answer += this.numDecodings(s, index + 2, dp) * 6;
                }
            } else if (s.charAt(index) != '*' && s.charAt(index = 1) != '*') {
                if ((s.charAt(index) - '0') * 10 + (s.charAt(index + 1) - '0') <= 26) {
                    answer += this.numDecodings(s, index + 2, dp);
                }
            }
        }
        answer %= 1000000007;
        dp[index] = (int) answer;
        return (int) answer;
    }

    public int numDecodings3(String s) {
        if (s == null || s.isEmpty() || s.isBlank()) {
            return 0;
        }
        long[] dp = new long[s.length() + 1];
        dp[s.length()] = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            dp[i] = dp[i + 1] * (s.charAt(i) == '*' ? 9 : 1);
            if (i + 1 < s.length()) {
                if (s.charAt(i) == '*' && s.charAt(i + 1) == '*') {
                    dp[i] += dp[i + 2] * 15;
                } else if (s.charAt(i) == '*' && s.charAt(i + 1) != '*') {
                    dp[i] += dp[i + 2] * ((s.charAt(i + 1) - '0') > 6 ? 1 : 2);
                } else if (s.charAt(i) != '*' && s.charAt(i + 1) == '*') {
                    if (s.charAt(i) == '1') {
                        dp[i] += dp[i + 2] * 9;
                    } else if (s.charAt(i) == '2') {
                        dp[i] += dp[i + 2] * 6;
                    }
                } else if (s.charAt(i) != '*' && s.charAt(i + 1) != '*') {
                    if ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26) {
                        dp[i] += dp[i + 2];
                    }
                }
            }
            dp[i] %= 1000000007;
        }

        return (int) dp[0];
    }

    public int numDecodings4(String s) {
        if (s == null || s.isEmpty() || s.isBlank()) {
            return 0;
        }

        int next = 1, nnext = 0;
        for (int i = s.length() - 1, current; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                current = 0;
            } else {
                current = next * (s.charAt(i) == '*' ? 9 : 1);
                if (i + 1 < s.length()) {
                    if (s.charAt(i) == '*' && s.charAt(i + 1) == '*') {
                        current += nnext * 15;
                    } else if (s.charAt(i) == '*' && s.charAt(i + 1) != '*') {
                        current += nnext * ((s.charAt(i + 1) - '0') > 6 ? 1 : 2);
                    } else if (s.charAt(i) != '*' && s.charAt(i + 1) == '*') {
                        if (s.charAt(i) == '1') {
                            current += nnext * 9;
                        } else if (s.charAt(i) == '2') {
                            current += nnext * 6;
                        }
                    } else if (s.charAt(i) != '*' && s.charAt(i + 1) != '*') {
                        if ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26) {
                            current += nnext;
                        }
                    }
                }
            }
            nnext = next;
            next = current % 1000000007;
        }

        return next;
    }
}
