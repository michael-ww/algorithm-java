package gorgeous.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode90 {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        this.dfs(nums, 0, new ArrayList<>(), answer);
        return answer;
    }

    private void dfs(int[] nums, int index, List<Integer> path, List<List<Integer>> answer) {
        answer.add(new ArrayList<>(path));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            dfs(nums, i + 1, path, answer);
            path.remove(path.size() - 1);
        }
    }
}
