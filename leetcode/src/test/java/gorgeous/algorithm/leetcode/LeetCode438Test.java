package gorgeous.algorithm.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LeetCode438Test {

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void findAnagrams_inputs_expectedOutputs(String source, String pattern, List<Integer> expected) {
        // Given
        LeetCode438 solution = new LeetCode438();

        // When
        List<Integer> actual = solution.findAnagrams(source, pattern);

        // Then
        Assertions.assertIterableEquals(expected, actual);
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of("cbaebabacd", "abc", Arrays.asList(0, 6)),
                Arguments.of("abab", "ab", Arrays.asList(0, 1, 2)),
                Arguments.of("abcdefg", "hij", Collections.emptyList()),
                Arguments.of("", "a", Collections.emptyList()),
                Arguments.of("abc", "", Collections.emptyList()),
                Arguments.of(null, "abc", Collections.emptyList()),
                Arguments.of("abc", null, Collections.emptyList()),
                Arguments.of("ab", "abc", Collections.emptyList()),
                Arguments.of("aaaaa", "aa", Arrays.asList(0, 1, 2, 3)),
                Arguments.of("a", "a", Arrays.asList(0))
        );
    }
}
