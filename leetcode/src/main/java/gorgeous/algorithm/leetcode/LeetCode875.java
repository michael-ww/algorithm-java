package gorgeous.algorithm.leetcode;

public class LeetCode875 {

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }
        int answer = 0;
        while (low <= high) {
            int speed = low + (high - low) >> 1;
            if (this.GetTime(piles, speed) > h) {
                low = speed + 1;
            } else {
                answer = speed;
                high = speed - 1;
            }
        }
        return answer;
    }

    private int GetTime(int[] piles, int speed) {
        int time = 0;
        for (int pile : piles) {
            time += (pile + speed - 1) / speed;
        }
        return time;
    }
}
