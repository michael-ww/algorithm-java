package gorgeous.algorithm.leetcode;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeetCode912Test {

    @Test
    public void quickSort_validInput_performExpected() {
        for (int i = 0; i < 100; i++) {
            // given
            int[] nums = Utility.generate(i + 1, (int) Math.ceil(Math.random() * 10), false, true);
            int[] copy = Arrays.copyOf(nums, nums.length);

            // when
            new LeetCode912().quickSort(nums, 0, nums.length - 1);
            Arrays.sort(copy);

            // then
            Assertions.assertArrayEquals(nums, copy);
        }
    }

    public void mergeSort_validInput_performExpected() {
        for (int i = 0; i < 100; i++) {
            // given
            int[] nums = Utility.generate(i + 1, (int) Math.ceil(Math.random() * 10), false, true);
            int[] copy = Arrays.copyOf(nums, nums.length);

            // when
            new LeetCode912().mergeSort(nums, 0, nums.length - 1);
            Arrays.sort(copy);

            // then
            Assertions.assertArrayEquals(nums, copy);
        }
    }

    @Test
    public void heapSort_validInput_performExpected() {
        for (int i = 0; i < 100; i++) {
            // given
            int[] nums = Utility.generate(i + 1, (int) Math.ceil(Math.random() * 10), false, true);
            int[] copy = Arrays.copyOf(nums, nums.length);

            // when
            new LeetCode912().heapSort(nums, 0, nums.length - 1);
            Arrays.sort(copy);

            // then
            Assertions.assertArrayEquals(nums, copy);
        }
    }
}
