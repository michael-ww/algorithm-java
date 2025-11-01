package gorgeous.algorithm.leetcode;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LeetCode1004Test {

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void longestOnes_variousInputs_expectedOutputs(int[] nums, int k, int expected) {
        // Given
        LeetCode1004 solution = new LeetCode1004();

        // When
        int actual = solution.longestOnes(nums, k);

        // Then
        Assertions.assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2, 6),
                Arguments.of(new int[]{0, 0, 1, 1, 1, 0, 0}, 0, 3),
                Arguments.of(new int[]{1, 1, 1, 1, 1}, 1, 5),
                Arguments.of(new int[]{0, 0, 0, 0}, 2, 2),
                Arguments.of(new int[]{}, 1, 0),
                Arguments.of(null, 2, 0),
                Arguments.of(new int[]{0, 1, 0, 1, 0, 1, 0}, 10, 7),
                Arguments.of(new int[]{1}, 0, 1),
                Arguments.of(new int[]{0}, 1, 1),
                Arguments.of(new int[]{0, 1, 0, 1, 0, 1, 0}, 0, 1)
        );
    }
}
