package gorgeous.algorithm.leetcode;

import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LeetCode92Test {

    @ParameterizedTest
    @MethodSource("provideTestCases")
    public void reverseBetween_validInput_returnHead(ListNode<Integer> head, int left, int right, int[] expected) {
        // given
        LeetCode92 leetCode92 = new LeetCode92();

        // when
        ListNode<Integer> actual = leetCode92.reverseBetween(head, left, right);

        // then
        Assertions.assertArrayEquals(expected, toArray(actual));
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(buildList(1, 2, 3, 4, 5), 2, 4, new int[]{1, 4, 3, 2, 5}),
                Arguments.of(buildList(1, 2, 3), 1, 3, new int[]{3, 2, 1}),
                Arguments.of(buildList(1), 1, 1, new int[]{1}),
                Arguments.of(buildList(1, 2, 3, 4), 3, 3, new int[]{1, 2, 3, 4}),
                Arguments.of(buildList(1, 2, 3, 4, 5), 3, 5, new int[]{1, 2, 5, 4, 3})
        );
    }

    private static ListNode<Integer> buildList(int... values) {
        ListNode<Integer> dummy = new ListNode<>(null);
        ListNode<Integer> curr = dummy;
        for (int v : values) {
            curr.setNext(new ListNode<>(v));
            curr = curr.getNext();
        }
        return dummy.getNext();
    }

    private int[] toArray(ListNode<Integer> head) {
        java.util.List<Integer> list = new java.util.ArrayList<>();
        while (head != null) {
            list.add(head.getValue());
            head = head.getNext();
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
