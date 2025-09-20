package gorgeous.algorithm.leetcode;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LeetCode772Test {

    @Disabled
    @ParameterizedTest
    @MethodSource("testcases")
    public void calculate_validInputs_returnExpectations(String input, int expectation) {
        LeetCode772 leetCode772 = new LeetCode772();
        int actual = leetCode772.calculate(input);
        Assertions.assertEquals(expectation, actual);
    }

    private static Stream<Arguments> testcases() {
        return Stream.of(
                Arguments.of("5-4", 1),
                Arguments.of("4*5", 20),
                Arguments.of("8/3", 2),
                Arguments.of("3 + 2*4", 11),
                Arguments.of("10-6/3", 5),
                Arguments.of("2 * (3+4)", 14),
                Arguments.of("(2+1)*3", 9),
                Arguments.of("2*(3+(4*2)) + 1", 17),
                Arguments.of("((1+2)+(3+1))*1", 7),
                Arguments.of("42", 42)
        );
    }
}
