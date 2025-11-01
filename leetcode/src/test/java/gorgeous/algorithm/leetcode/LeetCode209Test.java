package gorgeous.algorithm.leetcode;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LeetCode209Test {

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void minSubArrayLen_variousInputs_expectedOutputs(int target, int[] nums, int expected) {
        // Given
        var solution = new LeetCode209();

        // When
        int actual = solution.minSubArrayLen(target, nums);

        // Then
        Assertions.assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(7, new int[]{2, 3, 1, 2, 4, 3}, 2),
                Arguments.of(11, new int[]{1, 1, 1, 1, 1}, 0),
                Arguments.of(4, new int[]{1, 4, 4}, 1),
                Arguments.of(5, new int[]{}, 0),
                Arguments.of(5, null, 0),
                Arguments.of(5, new int[]{10, 20, 30}, 1),
                Arguments.of(11, new int[]{1, 2, 3, 4, 5}, 3)
        );
    }
}
