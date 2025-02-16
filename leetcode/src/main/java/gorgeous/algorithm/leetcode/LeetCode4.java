package gorgeous.algorithm.leetcode;

public class LeetCode4 {

    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length <= 0) {
            if (nums2.length % 2 == 0) {
                return (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2d;
            } else {
                return nums2[nums2.length / 2];
            }
        }
        if (nums2 == null || nums2.length <= 0) {
            if (nums1.length % 2 == 0) {
                return (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2d;
            } else {
                return nums1[nums1.length / 2];
            }
        }

        int previous = 0, median = 0;
        for (int i = 0, index1 = 0, index2 = 0; i <= (nums1.length + nums2.length) / 2; i++) {
            previous = median;
            median = index1 < nums1.length && (index2 >= nums2.length || nums1[index1] < nums2[index2])
                    ? nums1[index1++]
                    : nums2[index2++];
        }

        if ((nums1.length + nums2.length) % 2 == 0) {
            return (previous + median) / 2d;
        } else {
            return median;
        }
    }

    public double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length <= 0) {
            if (nums2.length % 2 == 0) {
                return (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2d;
            } else {
                return nums2[nums2.length / 2];
            }
        }
        if (nums2 == null || nums2.length <= 0) {
            if (nums1.length % 2 == 0) {
                return (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2d;
            } else {
                return nums1[nums1.length / 2];
            }
        }
        if ((nums1.length + nums2.length) % 2 == 0) {
            return (this.getKthElement(nums1, nums2, (nums1.length + nums2.length) / 2)
                    + this.getKthElement(nums1, nums2, (nums1.length + nums2.length) / 2 + 1)) / 2d;
        } else {
            return this.getKthElement(nums1, nums2, (nums1.length + nums2.length) / 2);
        }
    }

    private int getKthElement(int[] nums1, int[] nums2, int kth) {
        if (nums1 == null || nums1.length <= 0) {
            return nums2[kth - 1];
        }
        if (nums2 == null || nums2.length <= 0) {
            return nums1[kth - 1];
        }

        int nums1Index = 0, nums2Index = 0;
        while (true) {
            if (nums1Index >= nums1.length) {
                return nums2[nums2Index + kth - 1];
            }
            if (nums2Index >= nums2.length) {
                return nums1[nums1Index + kth - 1];
            }
            if (kth == 1) {
                return Math.min(nums1[nums1Index], nums2[nums2Index]);
            }

            int index1 = Math.min(nums1Index + kth / 2, nums1.length) - 1;
            int index2 = Math.min(nums2Index + kth / 2, nums2.length) - 1;
            if (nums1[index1] <= nums2[index2]) {
                kth -= index1 - nums1Index + 1;
                nums1Index = index1 + 1;
            } else {
                kth -= index2 - nums2Index + 1;
                nums2Index = index2 + 1;
            }
        }
    }

    public double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length <= 0) {
            if (nums2.length % 2 == 0) {
                return (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2d;
            } else {
                return nums2[nums2.length / 2];
            }
        }
        if (nums2 == null || nums2.length <= 0) {
            if (nums1.length % 2 == 0) {
                return (nums1[nums1.length / 2 - 1] + nums1[nums1.length / 2]) / 2d;
            } else {
                return nums1[nums1.length / 2];
            }
        }

        if (nums1.length > nums2.length) {
            this.findMedianSortedArrays3(nums2, nums1);
        }

        int leftIndex = 0, rightIndex = nums1.length;
        while (leftIndex < rightIndex) {
            int i = leftIndex + (rightIndex - leftIndex) / 2;
            int j = (nums1.length + nums2.length + 1) / 2 - i;
            if (nums1[i - 1] > nums2[j]) {
                rightIndex = i - 1;
            } else {
                leftIndex = i;
            }
        }

        int i = leftIndex;
        int j = (nums1.length + nums2.length + 1) / 2 - i;
        int nums1LeftMax = leftIndex == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = leftIndex == nums1.length ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == nums2.length ? Integer.MAX_VALUE : nums2[j];
        if ((nums1.length + nums2.length) % 2 == 0) {
            return (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2d;
        } else {
            return Math.max(nums1LeftMax, nums2LeftMax);
        }
    }
}
