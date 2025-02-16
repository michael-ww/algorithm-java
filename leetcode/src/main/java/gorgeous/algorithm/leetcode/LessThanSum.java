package gorgeous.algorithm.leetcode;

public class LessThanSum {

    public int process(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        return this.process(nums, 0, nums.length - 1);
    }

    private int process(int[] nums, int leftIndex, int rightIndex) {
        if (leftIndex == rightIndex) {
            return 0;
        }
        int middleIndex = leftIndex + ((rightIndex - leftIndex) >> 1);
        int leftSum = this.process(nums, leftIndex, middleIndex);
        int rightSum = this.process(nums, middleIndex + 1, rightIndex);
        int mergeSum = this.merge(nums, leftIndex, middleIndex, rightIndex);
        return leftSum + rightSum + mergeSum;
    }

    private int merge(int[] nums, int leftIndex, int middleIndex, int rightIndex) {
        int[] orderArray = new int[rightIndex - leftIndex + 1];
        int left = leftIndex, right = middleIndex + 1, orderArrayIndex = 0, answer = 0;
        while (left <= middleIndex && right <= rightIndex) {
            if (nums[left] < nums[right]) {
                answer += nums[left] * (rightIndex - right + 1);
                orderArray[orderArrayIndex++] = nums[left++];
            } else {
                orderArray[orderArrayIndex++] = nums[right++];
            }
        }
        while (left <= middleIndex) {
            orderArray[orderArrayIndex++] = nums[left++];
        }
        while (right <= rightIndex) {
            orderArray[orderArrayIndex++] = nums[right++];
        }

        System.arraycopy(orderArray, 0, nums, leftIndex, orderArray.length);

        return answer;
    }
}
