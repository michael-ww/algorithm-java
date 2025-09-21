package gorgeous.algorithm.leetcode;

import java.security.InvalidParameterException;
import java.util.random.RandomGenerator;

public class LeetCode215 {

    public int findKthLargest1(int[] nums, int k) {
        if (nums == null) {
            throw new NullPointerException();
        }
        if (k < 0 || k > nums.length) {
            throw new InvalidParameterException();
        }
        return this.select(nums, nums.length - k, 0, nums.length - 1);
    }

    private int select(int[] nums, int kthIndex, int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            return nums[leftIndex];
        }

        int pivotIndex = leftIndex + RandomGenerator.getDefault().nextInt(rightIndex - leftIndex + 1);
        int[] pivotBoundary = this.partition(nums, leftIndex, rightIndex, nums[pivotIndex]);
        if (kthIndex >= pivotBoundary[0] && kthIndex <= pivotBoundary[1]) {
            return nums[pivotBoundary[0]];
        } else if (kthIndex < pivotBoundary[0]) {
            return this.select(nums, kthIndex, leftIndex, pivotBoundary[0] - 1);
        } else {
            return this.select(nums, kthIndex, pivotBoundary[1] + 1, rightIndex);
        }

    }

    private int[] partition(int[] nums, int leftIndex, int rightIndex, int pivot) {
        int cusor = leftIndex;
        while (cusor <= rightIndex) {
            if (nums[cusor] > pivot) {
                Utility.swap(nums, cusor, rightIndex--);
            } else if (nums[cusor] < pivot) {
                Utility.swap(nums, cusor++, leftIndex++);
            } else {
                cusor++;
            }
        }
        return new int[]{leftIndex, rightIndex};
    }

    public int findKthLargest2(int[] nums, int k) {
        if (nums == null) {
            throw new NullPointerException();
        }
        if (k < 0 || k > nums.length) {
            throw new InvalidParameterException();
        }
        for (int i = 0; i < nums.length; i++) {
            this.heapInsert(nums, i);
        }
        int heapSize = nums.length;
        int kthNumber = nums[0];
        while (k > 0) {
            kthNumber = nums[0];
            Utility.swap(nums, 0, --heapSize);
            this.heapify(nums, 0, heapSize);
            k--;
        }
        return kthNumber;
    }

    private void heapInsert(int[] nums, int index) {
        while (nums[index] > nums[(index - 1) / 2]) {
            Utility.swap(nums, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private void heapify(int[] nums, int index, int heapSize) {
        int left = 2 * index + 1;
        while (left < heapSize) {
            int largest = left + 1 < heapSize && nums[left + 1] > nums[left] ? left + 1 : left;
            largest = nums[index] > nums[largest] ? index : largest;
            if (largest == index) {
                return;
            }
            Utility.swap(nums, index, largest);
            index = largest;
            left = 2 * index + 1;
        }
    }
}
