package gorgeous.algorithm.leetcode;

class NumArray {

    private final int[] previousSum;

    public NumArray(int[] nums) {
        this.previousSum = new int[nums.length + 1];
        for (int i = 1; i < previousSum.length; i++) {
            previousSum[i] = previousSum[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        return previousSum[right + 1] - previousSum[left];
    }
}
