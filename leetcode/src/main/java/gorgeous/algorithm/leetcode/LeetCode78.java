package gorgeous.algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        this.dfs(nums, 0, new ArrayList<>(), answer);
        return answer;
    }

    private void dfs(int[] nums, int index, List<Integer> path, List<List<Integer>> answer) {
        answer.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; i++) {
            path.add(nums[i]);
            this.dfs(nums, i + 1, path, answer);
            path.remove(path.size() - 1);
        }
    }
}
