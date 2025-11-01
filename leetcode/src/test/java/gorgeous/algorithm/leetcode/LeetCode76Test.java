package gorgeous.algorithm.leetcode;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


public class LeetCode76Test {

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void minWindow_variousInputs_expectedOutputs(String source, String target, String expected) {
        // Given
        LeetCode76 leetCode76 = new LeetCode76();

        // When
        String actual = leetCode76.minWindow(source, target);

        // Then
        Assertions.assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of("ADOBECODEBANC", "ABC", "BANC"),
                Arguments.of("A", "AA", ""),
                Arguments.of("ABC", "ABC", "ABC"),
                Arguments.of("AAABBC", "ABC", "ABBC"),
                Arguments.of("", "A", ""),
                Arguments.of("A", "", ""),
                Arguments.of("AAB", "AAB", "AAB"),
                Arguments.of("AAABBBCCC", "AABC", "AABBBC"),
                Arguments.of(null, "A", ""),
                Arguments.of("A", null, ""),
                Arguments.of(null, null, ""),
                Arguments.of("", "", ""),
                Arguments.of("A", "B", ""),
                Arguments.of("A", "A", "A"),
                Arguments.of("AA", "A", "A"),
                Arguments.of("AA", "AA", "AA"),
                Arguments.of("ABCD", "E", ""),
                Arguments.of("ADOBECODEBANC", "XYZ", ""),
                Arguments.of("ADOBECODEBANC", "A", "A"),
                Arguments.of("ADOBECODEBANC", "B", "B"),
                Arguments.of("ADOBECODEBANC", "C", "C"),
                Arguments.of("a", "a", "a"),
                Arguments.of("a", "b", "")
        );
    }
}
