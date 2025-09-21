package gorgeous.algorithm.leetcode;

import org.junit.jupiter.api.Assertions;

public class LeetCode23Test {

    public void mergeKLists_validInput_returnHead() {

        // Given
        ListNode<Integer> ln13 = new ListNode<>(5);
        ListNode<Integer> ln12 = new ListNode<>(4, ln13);
        ListNode<Integer> ln11 = new ListNode<>(1, ln12);

        ListNode<Integer> ln23 = new ListNode<>(4);
        ListNode<Integer> ln22 = new ListNode<>(3, ln23);
        ListNode<Integer> ln21 = new ListNode<>(1, ln22);

        ListNode<Integer> ln32 = new ListNode<>(6);
        ListNode<Integer> ln31 = new ListNode<>(2, ln32);

        @SuppressWarnings("unchecked")
        ListNode<Integer>[] listNodes = new ListNode[]{ln11, ln21, ln31};

        // When
        ListNode<Integer> answer = new LeetCode23().mergeKLists(listNodes);

        // Then
        Assertions.assertEquals(1, answer.getValue());
        Assertions.assertEquals(1, answer.getNext().getValue());
        Assertions.assertEquals(2, answer.getNext().getNext().getValue());
        Assertions.assertEquals(3, answer.getNext().getNext().getNext().getValue());
        Assertions.assertEquals(4, answer.getNext().getNext().getNext().getNext().getValue());
        Assertions.assertEquals(4, answer.getNext().getNext().getNext().getNext().getNext().getValue());
        Assertions.assertEquals(5, answer.getNext().getNext().getNext().getNext().getNext().getNext().getValue());
        Assertions.assertEquals(6,
                answer.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getValue());
    }
}
