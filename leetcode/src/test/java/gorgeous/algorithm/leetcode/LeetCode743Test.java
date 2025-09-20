package gorgeous.algorithm.leetcode;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LeetCode743Test {

    @Disabled
    @ParameterizedTest
    @MethodSource("testCases")
    public void networkDelayTime_validInputs_returnExpectations(int[][] times, int n, int k, int expected) {
        LeetCode743 leetCode743 = new LeetCode743();
        int actual = leetCode743.networkDelayTime(times, n, k);
        Assertions.assertEquals(expected, actual);
    }

    private static Stream<Arguments> testCases() {
        return Stream.of(
                Arguments.of(new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}}, 4, 2, 2),
                Arguments.of(new int[][]{{1, 2, 1}}, 2, 1, 1),
                Arguments.of(new int[][]{{1, 2, 1}}, 2, 2, -1)
        );
    }
}
