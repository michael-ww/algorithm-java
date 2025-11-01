package gorgeous.algorithm;

public class DifferenceArray {

    private final int[] difference;

    public DifferenceArray(int[] nums) {
        difference = new int[nums.length];
        difference[0] = nums[0];
        for (int i = 1; i < difference.length; i++) {
            difference[i] = nums[i] - nums[i - 1];
        }
    }

    // value can be positive or negative
    public void increment(int i, int j, int value) {
        difference[i] += value;
        if (j + 1 < difference.length) {
            difference[j + 1] -= value;
        }
    }

    public int[] getResult() {
        int[] result = new int[difference.length];
        result[0] = difference[0];
        for (int i = 1; i < result.length; i++) {
            result[i] = difference[i] + result[i - 1];
        }

        return result;
    }
}
