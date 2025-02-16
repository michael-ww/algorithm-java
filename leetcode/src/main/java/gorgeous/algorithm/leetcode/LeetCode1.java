package gorgeous.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LeetCode1 {

    public int[] twoSum1(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            if (hm.containsKey(target - nums[i])) {
                return new int[]{hm.get(target - nums[i]), i};
            }
            hm.put(nums[i], i);
        }
        return null;
    }
}
