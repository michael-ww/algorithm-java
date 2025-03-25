package gorgeous.algorithm.leetcode;

public class LeetCode868 {

    public int binaryGap(int n) {
        int lastIndex = n, currentIndex = 0, answer = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                answer = Math.max(answer, currentIndex - lastIndex);
                lastIndex = currentIndex;
            }
            currentIndex++;
            n >>= 1;
        }
        return answer;
    }
}
