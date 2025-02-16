package gorgeous.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return answer;
        }
        Arrays.sort(nums);
        for (int first = 0; first < nums.length; first++) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;
            }
            for (int second = first + 1; second < nums.length; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                int third = nums.length - 1;
                while (second < third && nums[first] + nums[second] + nums[third] > 0) {
                    third--;
                }
                if (second == third) {
                    break;
                }
                if (nums[first] + nums[second] + nums[third] == 0) {
                    answer.add(Arrays.asList(nums[first], nums[second], nums[third]));
                }
            }
        }

        return answer;
    }
}
