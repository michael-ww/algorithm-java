package gorgeous.algorithm.leetcode;

public class LeetCode2240 {

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        if (total < 0 || cost1 < 0 || cost2 < 0) {
            throw new IllegalArgumentException();
        }
        if (cost1 < cost2) {
            return this.waysToBuyPensPencils(total, cost2, cost1);
        }
        long answer = 0;
        for (int i = 0; i * cost1 <= total; i++) {
            answer += (total - i * cost1) / cost2 + 1;
        }

        return answer;
    }
}
