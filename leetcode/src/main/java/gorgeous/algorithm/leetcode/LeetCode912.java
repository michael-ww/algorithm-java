package gorgeous.algorithm.leetcode;

import java.util.Arrays;
import java.util.Stack;
import java.util.random.RandomGenerator;

import gorgeous.algorithm.common.Utility;

public class LeetCode912 {

    public int[] sortArray(int[] nums) {
        this.quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int pivotIndex = leftIndex + RandomGenerator.getDefault().nextInt(rightIndex - leftIndex + 1);
            int[] pivotIndexes = partition(nums, leftIndex, rightIndex, nums[pivotIndex]);
            quickSort(nums, leftIndex, pivotIndexes[0] - 1);
            quickSort(nums, pivotIndexes[1] + 1, rightIndex);
        }
    }

    private int[] partition(int[] nums, int leftIndex, int rightIndex, int pivot) {
        int cursor = leftIndex;
        while (cursor <= rightIndex) {
            if (nums[cursor] < pivot) {
                Utility.swap(nums, cursor++, leftIndex++);
            } else if (nums[cursor] > pivot) {
                Utility.swap(nums, cursor, rightIndex--);
            } else {
                cursor++;
            }
        }
        return new int[]{leftIndex, rightIndex};
    }

    public void mergeSort(int[] nums, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int middleIndex = leftIndex + (rightIndex - leftIndex) >> 1;
            mergeSort(nums, leftIndex, middleIndex);
            mergeSort(nums, middleIndex + 1, rightIndex);
            merge(nums, leftIndex, middleIndex, rightIndex);
        }
    }

    private void merge(int[] nums, int leftIndex, int middleIndex, int rightIndex) {
        int[] ordered = new int[rightIndex - leftIndex + 1];
        int orderedIndex = 0, leftCursor = leftIndex, rightCursor = middleIndex + 1;
        while (leftCursor <= middleIndex && rightCursor <= rightIndex) {
            ordered[orderedIndex++] = nums[leftCursor] < nums[rightCursor] ? nums[leftCursor++] : nums[rightCursor++];
        }
        while (leftCursor <= middleIndex) {
            ordered[orderedIndex++] = nums[leftCursor++];
        }
        while (rightCursor <= rightIndex) {
            ordered[orderedIndex++] = nums[rightCursor++];
        }
        System.arraycopy(ordered, 0, nums, leftIndex, ordered.length);
    }

    public void heapSort(int[] nums, int leftIndex, int rightIndex) {
        for (int i = leftIndex; i <= rightIndex; i++) {
            heapInsert(nums, i);
        }
        for (int i = rightIndex; i >= leftIndex; i--) {
            Utility.swap(nums, leftIndex, i);
            heapify(nums, leftIndex, i);
        }
    }

    private void heapInsert(int[] nums, int index) {
        while (nums[index] > nums[(index - 1) / 2]) {
            Utility.swap(nums, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    private void heapify(int[] nums, int index, int length) {
        int leftIndex = index * 2 + 1;
        while (leftIndex < length) {
            int largestIndex = leftIndex + 1 < length && nums[leftIndex + 1] > nums[leftIndex] ? leftIndex + 1 : leftIndex;
            largestIndex = nums[largestIndex] > nums[index] ? largestIndex : index;
            if (largestIndex == index) {
                break;
            }
            Utility.swap(nums, largestIndex, index);
            index = largestIndex;
            leftIndex = index * 2 + 1;
        }
    }

    public void selectionSort(int[] nums, int leftIndex, int rightIndex) {
        for (int i = leftIndex; i <= rightIndex; i++) {
            int minValueIndex = i;
            for (int j = i + 1; j <= rightIndex; j++) {
                minValueIndex = nums[minValueIndex] > nums[j] ? j : minValueIndex;
            }
            Utility.swap(nums, i, minValueIndex);
        }
    }

    public void bubbleSort(int[] nums, int leftIndex, int rightIndex) {
        for (int i = rightIndex; i >= leftIndex; i--) {
            for (int j = leftIndex; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    Utility.swap(nums, j, j + 1);
                }
            }
        }
    }

    public void insertionSort(int[] nums, int leftIndex, int rightIndex) {
        for (int i = leftIndex + 1; i <= rightIndex; i++) {
            for (int j = i - 1; j >= leftIndex; j--) {
                if (nums[j] > nums[j + 1]) {
                    Utility.swap(nums, j, j + 1);
                }
            }
        }
    }

    public void radixSort(int[] nums, int leftIndex, int rightIndex, int base) {
        int min = Arrays.stream(nums).min().getAsInt();
        if (min < 0) {
            for (int i = leftIndex; i <= rightIndex; i++) {
                nums[i] -= min;
            }
        }

        int[] counter = new int[base];
        int[] bucket = new int[rightIndex - leftIndex + 1];
        int bits = this.getMaxBits(nums);
        for (int offset = 1; bits > 0; offset *= base, bits--) {
            Arrays.fill(counter, 0);
            for (int i = leftIndex; i <= rightIndex; i++) {
                counter[nums[i] / offset % base]++;
            }
            for (int i = 1; i < base; i++) {
                counter[i] += counter[i - 1];
            }
            for (int i = rightIndex; i >= leftIndex; i--) {
                bucket[--counter[nums[i] / offset % base]] = nums[i];
            }
            System.arraycopy(bucket, 0, nums, leftIndex, rightIndex - leftIndex + 1);
        }

        if (min < 0) {
            for (int i = leftIndex; i <= rightIndex; i++) {
                nums[i] += min;
            }
        }
    }

    private int getMaxBits(int[] nums) {
        int answer = 0;
        int max = Arrays.stream(nums).max().getAsInt();
        while (max != 0) {
            max /= 10;
            answer++;
        }

        return answer;
    }

    public void stackSort(Stack<Integer> stack) {
        int depth = deep(stack);
        while (depth > 0) {
            int maximum = max(stack, depth);
            int times = times(stack, depth, maximum);
            down(stack, depth, maximum, times);
            depth -= times;
        }
    }

    private int deep(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return 0;
        } else {
            int number = stack.pop();
            int depth = deep(stack);
            stack.push(number);
            return depth + 1;
        }
    }

    private int max(Stack<Integer> stack, int depth) {
        if (stack.isEmpty()) {
            return Integer.MIN_VALUE;
        } else {
            int number = stack.pop();
            int restMaximum = max(stack, depth - 1);
            stack.push(number);
            return Math.max(restMaximum, number);
        }
    }

    private int times(Stack<Integer> stack, int depth, int maximum) {
        if (stack.isEmpty()) {
            return 0;
        } else {
            int number = stack.pop();
            int restTimes = times(stack, depth - 1, maximum);
            stack.push(number);
            return number == maximum ? restTimes + 1 : restTimes;
        }
    }

    private void down(Stack<Integer> stack, int depth, int maximum, int times) {
        if (stack.isEmpty()) {
            for (int i = 0; i < times; i++) {
                stack.push(maximum);
            }
        } else {
            int number = stack.pop();
            down(stack, depth - 1, maximum, times);
            if (number != maximum) {
                stack.push(number);
            }
        }
    }
}
