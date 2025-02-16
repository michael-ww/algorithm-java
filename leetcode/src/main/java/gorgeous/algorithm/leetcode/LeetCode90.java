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
        if (index >= nums.length) {
            answer.add(new ArrayList<>(path));
        } else {
            path.add(nums[index]);
            this.dfs(nums, index + 1, path, answer);
            path.remove(path.size() - 1);
            int next = index + 1;
            while (next < nums.length && nums[index] == nums[next]) {
                next++;
            }
            this.dfs(nums, next, path, answer);
        }
    }
}
