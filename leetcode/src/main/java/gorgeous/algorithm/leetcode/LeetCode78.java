package gorgeous.algorithm.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LeetCode78 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        this.dfs(nums, 0, new LinkedList<>(), answer);
        return answer;
    }

    private void dfs(int[] nums, int index, LinkedList<Integer> path, List<List<Integer>> answer) {
        if (index >= nums.length) {
            answer.add(new ArrayList<>(path));
        } else {
            this.dfs(nums, index + 1, path, answer);
            path.addLast(nums[index]);
            this.dfs(nums, index + 1, path, answer);
            path.removeLast();
        }
    }
}
