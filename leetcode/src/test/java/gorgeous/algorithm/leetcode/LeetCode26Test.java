package gorgeous.algorithm.leetcode;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LeetCode26Test {

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void removeDuplicates_variousInputs_expectedOutputs(int[] nums, int expected) {

        // Given
        LeetCode26 leetcode26 = new LeetCode26();

        // When
        int actual = leetcode26.removeDuplicates(nums);

        // Then
        Assertions.assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(null, 0),
                Arguments.of(new int[]{}, 0),
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 5),
                Arguments.of(new int[]{2, 2, 2, 2, 2}, 1),
                Arguments.of(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, 5),
                Arguments.of(new int[]{1, 1, 2, 3, 3, 4, 5, 5, 6}, 6)
        );
    }
}
