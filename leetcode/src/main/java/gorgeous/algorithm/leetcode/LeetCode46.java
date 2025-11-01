package gorgeous.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        this.backtrack(nums, new boolean[nums.length], new ArrayList<>(), answer);
        return answer;
    }

    private void backtrack(int[] nums, boolean[] used, List<Integer> path, List<List<Integer>> answer) {
        if (path.size() == nums.length) {
            answer.add(new ArrayList<>(path));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                path.add(nums[i]);
                used[i] = true;
                this.backtrack(nums, used, path, answer);
                path.removeLast();
                used[i] = false;
            }
        }
    }
}
