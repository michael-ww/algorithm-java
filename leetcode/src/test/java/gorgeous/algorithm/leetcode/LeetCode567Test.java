package gorgeous.algorithm.leetcode;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LeetCode567Test {

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void checkInclusion_variousInputs_expectedOutputs(String target, String source, boolean expected) {
        // Given
        LeetCode567 solution = new LeetCode567();

        // When
        boolean actual = solution.checkInclusion(target, source);

        // Then
        Assertions.assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of("ab", "eidboaoo", false),
                Arguments.of("abc", "abc", true),
                Arguments.of("adc", "dcda", true),
                Arguments.of("hello", "ooolleoooleh", false),
                Arguments.of("", "anything", true),
                Arguments.of("abc", "", false),
                Arguments.of(null, "abc", false),
                Arguments.of("abc", null, false),
                Arguments.of("abcd", "abc", false),
                Arguments.of("a", "a", true),
                Arguments.of("a", "b", false),
                Arguments.of("aabc", "caaab", false)
        );
    }
}
