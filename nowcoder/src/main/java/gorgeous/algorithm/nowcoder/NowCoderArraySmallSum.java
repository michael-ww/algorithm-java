package gorgeous.algorithm.nowcoder;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class NowCoderArraySmallSum {

    public static void main(String[] args) {
        String input = "6\n1 3 5 2 4 6";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(calculate(numbers, 0, length - 1));
    }

    private static int calculate(int[] numbers, int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return 0;
        }
        int middleIndex = (startIndex + endIndex) >> 1;
        int leftSum = calculate(numbers, startIndex, middleIndex);
        int rightSum = calculate(numbers, middleIndex + 1, endIndex);
        int mergeSum = merge(numbers, startIndex, middleIndex, endIndex);
        return leftSum + rightSum + mergeSum;
    }

    private static int merge(int[] numbers, int startIndex, int middleIndex, int endIndex) {
        int[] sorted = new int[endIndex - startIndex + 1];
        int sortedIndex = 0, leftIndex = startIndex, rightIndex = middleIndex + 1, result = 0;
        while (leftIndex <= middleIndex && rightIndex <= endIndex) {
            if (numbers[leftIndex] <= numbers[rightIndex]) {
                result += numbers[leftIndex] * (endIndex - rightIndex + 1);
                sorted[sortedIndex++] = numbers[leftIndex++];
            } else {
                sorted[sortedIndex++] = numbers[rightIndex++];
            }
        }
        while (leftIndex <= middleIndex) {
            sorted[sortedIndex++] = numbers[leftIndex++];
        }
        while (rightIndex <= endIndex) {
            sorted[sortedIndex++] = numbers[rightIndex++];
        }
        System.arraycopy(sorted, 0, numbers, startIndex, sorted.length);
        return result;
    }
}
