package gorgeous.algorithm.leetcode;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LeetCode283Test {

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void moveZeroes_variousInputs_expectedOutputs(int[] nums) {
        // Given
        LeetCode283 leetCode283 = new LeetCode283();

        // When
        leetCode283.moveZeroes(nums);

        // Then
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(new int[]{}),
                Arguments.of(new int[]{1}),
                Arguments.of(new int[]{0, 0, 0, 0}),
                Arguments.of(new int[]{1, 3, 12, 3, 12}),
                Arguments.of(new int[]{0, 1, 1, 0, 0, 2, 0, 0, 3, 0, 4})
        );
    }
}
